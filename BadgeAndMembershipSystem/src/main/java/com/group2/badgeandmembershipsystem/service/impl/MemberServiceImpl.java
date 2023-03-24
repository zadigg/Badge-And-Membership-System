package com.group2.badgeandmembershipsystem.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.group2.badgeandmembershipsystem.domain.*;
import com.group2.badgeandmembershipsystem.domain.enums.MembershipType;
import com.group2.badgeandmembershipsystem.dto.*;
import com.group2.badgeandmembershipsystem.event.SaveMemberEvent;
import com.group2.badgeandmembershipsystem.exception.ResourceException;
import com.group2.badgeandmembershipsystem.repository.MemberRepository;
import com.group2.badgeandmembershipsystem.repository.RoleRepository;
import com.group2.badgeandmembershipsystem.service.MemberService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private SaveMemberEvent saveMemberEvent;
    @Override
    public MemberDTO createNewMember(RegistrationDTO memberDTO) {
        Member toBeAdded = memberRepository.findMemberByEmailAddressIgnoreCase(memberDTO.getEmailAddress());
        if (toBeAdded != null) {
            throw new ResourceException("Member already exists with this email address", HttpStatus.CONFLICT);
        }
        Member member = modelMapper.map(memberDTO, Member.class);
        member.setPassword(bCryptPasswordEncoder.encode(member.getPassword()));
        List<Role> roles = memberDTO.getRoles().stream().map(role -> roleRepository.findByNameIgnoreCase(role.getName())).collect(Collectors.toList());
        member.setRoles(roles);
        Member newMember = memberRepository.save(member);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            RegistrationMessageDTO messageDTO = modelMapper.map(memberDTO, RegistrationMessageDTO.class);
            String memberMessage = objectMapper.writeValueAsString(messageDTO);
            saveMemberEvent.send(memberMessage.replaceAll("\"", "'"));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return modelMapper.map(newMember,MemberDTO.class);
    }

    @Override
    public MemberDTO updateMember(long id, UpdateMemberDTO memberDTO) {
        Member member = memberRepository.findById(id).orElseThrow(()->new ResourceException("Member Not found"));
        member.setId(id);
        member.setFirstName(memberDTO.getFirstName());
        member.setLastName(memberDTO.getLastName());
        Member updatedMember = memberRepository.save(member);
        return modelMapper.map(updatedMember, MemberDTO.class);
    }

    @Override
    public void deleteMember(long id) {
        Member member = memberRepository.findById(id).orElseThrow(()-> new ResourceException("Member Not found"));
        memberRepository.delete(member);
    }

    @Override
    public MemberDTO getMember(long id) {
        return memberRepository.findById(id).map(member -> modelMapper.map(member, MemberDTO.class)).orElseThrow(()-> new ResourceException("Member Not found"));
    }

    @Override
    public List<MemberDTO> getAllMembers() {
        return memberRepository.findAll().stream().map(member -> modelMapper.map(member, MemberDTO.class)).toList();
    }

    @Override
    public void changePassword(long id, PasswordDTO passwordDTO) {
        Member member = memberRepository.findById(id).orElseThrow(()->new ResourceException("Member Not found"));
        if (!passwordDTO.getNewPassword().equals(passwordDTO.getVerifyNewPassword())){
            throw new ResourceException("Password must match",HttpStatus.CONFLICT);
        }
        member.setId(id);
        member.setPassword(bCryptPasswordEncoder.encode(passwordDTO.getVerifyNewPassword()));
        memberRepository.save(member);
    }

    @Override
    public List<TransactionDTO> findTransactionsByMemberId(long memberId) {
        List<Transaction> transactions = memberRepository.findTransactionsByMemberId(memberId);
        if (transactions.isEmpty()){
            throw new ResourceException("No transactions for this member");
        }
        return transactions.stream().map(transaction -> modelMapper.map(transaction, TransactionDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<PlanDTO> findPlansByMemberId(long memberId) {
        List<Plan> plans = memberRepository.findPlansByMemberId(memberId);
        if (plans.isEmpty()){
            throw new ResourceException("No plans for this member");
        }
        return plans.stream().map(plan -> modelMapper.map(plan, PlanDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<BadgeDTO> findBadgesByMemberId(long memberId) {
        List<Badge> badges = memberRepository.findBadgesByMemberId(memberId);
        if (badges.isEmpty()){
            throw new ResourceException("No badges for this member");
        }
        return badges.stream().map(badge -> modelMapper.map(badge, BadgeDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<BadgeDTO> filterActiveBadgesOfMember(long memberId, String status) {
        List<Badge> badges = memberRepository.filterBadgesOfMember(memberId);
        if (badges.isEmpty()){
            throw new ResourceException("No badges for this member");
        }
        List<Badge> filteredBadges = badges.stream().filter(badge -> badge.getStatus().equals(status)).toList();
        if (filteredBadges.isEmpty()){
            throw new ResourceException("No badges for this member");
        }
        return filteredBadges.stream().map(badge -> modelMapper.map(badge, BadgeDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<MembershipDTO> findMembershipsByMemberId(long memberId) {
        List<Membership> memberships = memberRepository.findMembershipsByMemberId(memberId);
        if (memberships.isEmpty()){
            throw new ResourceException("No memberships for this member");
        }
        return memberships.stream().map(membership -> modelMapper.map(membership, MembershipDTO.class)).collect(Collectors.toList());

    }
    @Override
    public List<MembershipDTO> getAllCheckerMemberships(long memberId, String membershipType) {
        List<Membership> memberships= memberRepository.findMembershipsByMemberId(memberId);
        MembershipType type = MembershipType.valueOf(membershipType.toUpperCase());
        List<Membership> filteredMemberships = memberships.stream()
                .filter(membership -> membership.getMembershipType().equals(type))
                .filter(membership -> membership.getMembershipType().equals(MembershipType.CHECKER))
                .toList();
        if (filteredMemberships.isEmpty()){
            throw new ResourceException("You are not allowed to go further",HttpStatus.FORBIDDEN);
        }
        return filteredMemberships.stream().map(membership -> modelMapper.map(membership,MembershipDTO.class)).toList();
    }
}
