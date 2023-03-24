package com.group2.badgeandmembershipsystem.service.impl;

import com.group2.badgeandmembershipsystem.domain.Member;
import com.group2.badgeandmembershipsystem.domain.Membership;
import com.group2.badgeandmembershipsystem.domain.Plan;
import com.group2.badgeandmembershipsystem.domain.enums.MembershipType;
import com.group2.badgeandmembershipsystem.dto.MembershipDTO;
import com.group2.badgeandmembershipsystem.dto.MembershipRequestDTO;
import com.group2.badgeandmembershipsystem.exception.ResourceException;
import com.group2.badgeandmembershipsystem.repository.MemberRepository;
import com.group2.badgeandmembershipsystem.repository.MembershipRepository;
import com.group2.badgeandmembershipsystem.repository.PlanRepository;
import com.group2.badgeandmembershipsystem.service.MembershipService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MembershipServiceImpl implements MembershipService {
    @Autowired
    private MembershipRepository membershipRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private PlanRepository planRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public MembershipDTO createNewMembership(MembershipRequestDTO membershipDTO) {
        Plan plan = planRepository.findById(membershipDTO.getPlanId()).orElseThrow(()->new ResourceException("Plan Not found"));
        Member member = memberRepository.findById(membershipDTO.getMemberId()).orElseThrow(()->new ResourceException("Member Not found"));
        Membership membership = modelMapper.map(membershipDTO, Membership.class);
        membership.setPlan(plan);
        List<Membership> memberships = member.getMemberships();
        if(memberships == null) {
            memberships = new ArrayList<>();
        }
        memberships.add(membership);
        member.setMemberships(memberships);
        memberRepository.save(member);
//        Membership newMembership = membershipRepository.save(membership);
        return modelMapper.map(membership,MembershipDTO.class);
    }

    @Override
    public MembershipDTO updateMembership(long id, MembershipRequestDTO membershipDTO) {
        Membership oldMembership = membershipRepository.findById(id).orElseThrow(()->new ResourceException("Membership Not found"));
        Plan plan = planRepository.findById(membershipDTO.getPlanId()).orElseThrow(()->new ResourceException("Plan Not found"));
        Member member = memberRepository.findById(membershipDTO.getMemberId()).orElseThrow(()->new ResourceException("Member Not found"));
        Membership membership = modelMapper.map(membershipDTO,Membership.class);
        membership.setPlan(plan);
        membership.setId(oldMembership.getId());
        List<Membership> memberships = member.getMemberships();
        if(memberships == null) {
            memberships = new ArrayList<>();
        }
        memberships.add(membership);
        member.setMemberships(memberships);
        memberRepository.save(member);
//        Membership updatedMembership = membershipRepository.save(membership);
        return modelMapper.map(membership, MembershipDTO.class);
    }

    @Override
    public void deleteMembership(long id) {
        Membership membership = membershipRepository.findById(id).orElseThrow(() -> new ResourceException("Membership Not found"));
        membershipRepository.delete(membership);
    }

    @Override
    public MembershipDTO getMembership(long id) {
        return membershipRepository.findById(id).map(membership -> modelMapper.map(membership, MembershipDTO.class)).orElseThrow(() -> new ResourceException("Membership Not found"));
    }

    @Override
    public List<MembershipDTO> getAllMemberships() {
        List<Membership> memberships = membershipRepository.findAll();
        return memberships.stream().map(membership -> modelMapper.map(membership, MembershipDTO.class)).collect(Collectors.toList());
    }
}
