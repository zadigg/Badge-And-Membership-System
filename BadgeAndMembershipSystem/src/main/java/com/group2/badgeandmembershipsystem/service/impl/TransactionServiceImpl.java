package com.group2.badgeandmembershipsystem.service.impl;

import com.group2.badgeandmembershipsystem.domain.*;
import com.group2.badgeandmembershipsystem.domain.enums.MembershipType;
import com.group2.badgeandmembershipsystem.dto.TransactionDTO;
import com.group2.badgeandmembershipsystem.dto.TransactionRequestDTO;
import com.group2.badgeandmembershipsystem.exception.ResourceException;
import com.group2.badgeandmembershipsystem.exception.payload.ApiResponse;
import com.group2.badgeandmembershipsystem.repository.*;
import com.group2.badgeandmembershipsystem.service.TransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private BadgeRepository badgeRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private MembershipRepository membershipRepository;
    @Autowired
    private PlanRepository planRepository;
    @Autowired
    private LocationRepository locationRepository;

    @Override
    public TransactionDTO getTransaction(long id) {
        return transactionRepository.findById(id).map(transaction -> modelMapper.map(transaction, TransactionDTO.class)).orElseThrow(() -> new ResourceException("Transaction Not found"));
    }

    @Override
    public void deleteTransaction(long id) {
        Transaction transaction = transactionRepository.findById(id).orElseThrow(() -> new ResourceException("Transaction Not found"));
        transactionRepository.delete(transaction);
    }

    @Override
    public List<TransactionDTO> getAllTransactions() {
        List<Transaction> transactions = transactionRepository.findAll();
        return transactions.stream().map(transaction -> modelMapper.map(transaction, TransactionDTO.class)).collect(Collectors.toList());
    }

    @Override
    public TransactionDTO updateTransaction(long id, TransactionDTO transactionDTO) {
        Transaction oldTransaction = transactionRepository.findById(id).orElseThrow(()->new ResourceException("Transaction Not found"));
        Transaction transaction = modelMapper.map(transactionDTO,Transaction.class);
        transaction.setId(oldTransaction.getId());
        transaction.setDateTime(LocalDateTime.now());
        Transaction updatedTransaction = transactionRepository.save(transaction);
        return modelMapper.map(updatedTransaction, TransactionDTO.class);
    }
    @Override
    public ApiResponse createTransaction(TransactionRequestDTO transactionDTO) {
        transactionDTO.setDateTime(LocalDateTime.now());
        ApiResponse apiResponse = new ApiResponse();
        Transaction transaction = modelMapper.map(transactionDTO, Transaction.class);
        try {
            Plan plan = planRepository.findById(transactionDTO.getPlanId()).orElseThrow(() -> new ResourceException("Plan does not exist at all"));
            Location location = locationRepository.findByLocationId(transactionDTO.getLocationId()).orElseThrow(() -> new ResourceException("Location does not exist"));
            transaction.setPlan(plan);
            transaction.setLocation(location);
//        check the badge
            Badge badge = getBadge(transactionDTO.getBadgeId());
            transaction.setBadge(badge);
//        check the member of the badge
            Member member = getMemberOfBadge(badge.getMember().getId());
//        check the membership of that member
            Membership filteredMembership = checkMembershipOfMember(member, transactionDTO.getPlanId());
//        check the membership validity
            checkMembershipValidity(filteredMembership, transactionDTO.getDateTime());
//        check the time of punch
            checkTimeOfPunch(transactionDTO.getLocationId(), transactionDTO.getDateTime());
//        check membership type and look whether its limited or not limited
            MembershipType membershipType = filteredMembership.getMembershipType();
//            if (membershipType.equals(MembershipType.LIMITED)) {
//                //check if number of allowance > 0 if not throw saying no number of allowance remaining
//                getTransactionsOfABadge(transactionDTO.getBadgeId(), transactionDTO.getDateTime());
//                if (badge.getMember().getRoles().stream().anyMatch(item -> item.getName().equals("Student"))) {
//                    getAllTransactions().stream().filter(item -> item.getBadge().getBadgeId().equals(transactionDTO.getBadgeId()));
//                }
//            }

            //decrease allowance count for limited membership
            if(filteredMembership.getMembershipType() == MembershipType.LIMITED) {
//                check allowances availability
                checkAllowancesAvailability(filteredMembership.getNumberOfAllowances());
//                check single entry for student
                checkSingleEntryForStudent(badge, location);
                filteredMembership.setNumberOfAllowances(filteredMembership.getNumberOfAllowances() - 1);
                membershipRepository.save(filteredMembership);
            }
            transaction.setTransactionType("ACCEPTED");
             apiResponse = ApiResponse.builder().message("ACCEPTED: Checked In....").success(true).status(HttpStatus.OK).build();
        }
        catch (ResourceException exception) {
            transaction.setTransactionType("DECLINED");
            apiResponse = ApiResponse.builder().message("DECLINED: "+exception.getMessage()).success(false).status(HttpStatus.OK).build();
        }
        transactionRepository.save(transaction);
        return apiResponse;
    }
    private Badge getBadge(String badgeId){
        Badge badge = badgeRepository.findByBadgeId(badgeId).orElseThrow(()->new ResourceException("Badge is not recognized"));
        if (badge.getStatus().equals("INACTIVE")){
            throw new ResourceException("Badge is not active");
        }
        return badge;
    }
    private Member getMemberOfBadge(long id){
        return memberRepository.findById(id).orElseThrow(()->new ResourceException("Member Not found"));
    }
    private Membership checkMembershipOfMember(Member member,long planId){
        //        check the membership of that member
        List<Membership> memberships = member.getMemberships();
//        check whether the member has membership for that plan or not
        return memberships.stream()
                .filter(membership -> membership.getPlan().getId()==planId).findAny().orElseThrow(()->new ResourceException("No membership for this plan"));

    }
    private void checkMembershipValidity(Membership membership,LocalDateTime dateTime){
        LocalDate startDate = membership.getStartDate();
        LocalDate endDate = membership.getEndDate();
        LocalDate today = LocalDate.from(dateTime);
        if (today.isAfter(endDate) || today.isBefore(startDate)){
            throw new ResourceException("Your membership has expired");
        }
    }
    // get Time Slots
    private List<Timeslot> getTimeSlots(String locationId){
        Location location = locationRepository.findByLocationIdIgnoreCase(locationId);
        return location.getTimeslots();
    }
    // get a day
    private String getDay(LocalDateTime dateTime){
        return dateTime.getDayOfWeek().name();
    }
    private void checkTimeOfPunch(String locationId,LocalDateTime dateTime){
        LocalTime punchTime = LocalTime.from(dateTime);
        List<Timeslot> timeslots = getTimeSlots(locationId);
        String day = getDay(dateTime);
        List<Timeslot> updatedTimeSlots = timeslots.stream().filter(timeslot -> timeslot.getDayOfTheWeek().toUpperCase().equals(day)).toList();
        if (status(updatedTimeSlots,punchTime)) {
            throw new ResourceException("You cannot enter the location now");
        }
    }
    private boolean status(List<Timeslot> timeslots,LocalTime punchTime) {
        return timeslots.stream().allMatch(item -> item.getStartTime().isAfter(punchTime) || item.getEndTime().isBefore(punchTime));
    }

    private void checkAllowancesAvailability(int allowances){
        if (allowances<0){
            throw new ResourceException("You have no allowances left");
        }
    }
    private void checkSingleEntryForStudent(Badge badge, Location location) {
        if (!badge.getMember().getRoles().stream().anyMatch(item->!item.getName().equals("Student"))){
            Timeslot currentActiveTimeslot = getCurrentOpenTimeslotForLocation(location);
            LocalDateTime startDateTime = LocalDateTime.of(LocalDate.now(), currentActiveTimeslot.getStartTime());
            LocalDateTime endDateTime = LocalDateTime.of(LocalDate.now(), currentActiveTimeslot.getEndTime());
            int usedTransactionTimeslot = transactionRepository.countAcceptedByLocationIdAndTimeInBetween(badge.getBadgeId(),startDateTime,endDateTime);
            if (usedTransactionTimeslot > 0){
                throw new ResourceException("You have already checked in");
            }
        }
    }
    private Timeslot getCurrentOpenTimeslotForLocation(Location location){
        LocalDateTime now = LocalDateTime.now();
        LocalTime time = LocalTime.now();
        String day = getDay(now);
        List<Timeslot> todayTimeslots = location.getTimeslots().stream()
                .filter(slot -> slot.getDayOfTheWeek().toUpperCase().equals(day.toUpperCase())).collect(Collectors.toList());
        Timeslot timeslot = todayTimeslots.stream()
                .filter(slot -> time.isAfter(slot.getStartTime()) && time.isBefore(slot.getEndTime()))
                .findFirst().orElseThrow(()->new ResourceException(""));
        return timeslot;
    }
    private int getTransactionsOfABadge(String badgeId,LocalDateTime dateTime){
        List<Transaction> transactions = transactionRepository.findByBadgeId(badgeId);
        return 0;
    }
}
