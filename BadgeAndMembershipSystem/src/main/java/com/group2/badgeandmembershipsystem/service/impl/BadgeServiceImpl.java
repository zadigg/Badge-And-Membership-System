package com.group2.badgeandmembershipsystem.service.impl;

import com.group2.badgeandmembershipsystem.domain.Badge;
import com.group2.badgeandmembershipsystem.domain.Member;
import com.group2.badgeandmembershipsystem.dto.BadgeDTO;
import com.group2.badgeandmembershipsystem.dto.BadgeRequestDTO;
import com.group2.badgeandmembershipsystem.exception.ResourceException;
import com.group2.badgeandmembershipsystem.repository.BadgeRepository;
import com.group2.badgeandmembershipsystem.repository.MemberRepository;
import com.group2.badgeandmembershipsystem.service.BadgeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BadgeServiceImpl implements BadgeService {
    @Autowired
    private BadgeRepository badgeRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<BadgeDTO> findAll() {
        List<Badge> badges = badgeRepository.findAll();
        return badges.stream().map(plan -> modelMapper.map(plan, BadgeDTO.class)).collect(Collectors.toList());
    }

    public BadgeDTO findById(String id) {
        return badgeRepository.findByBadgeId(id).map(badge -> modelMapper.map(badge, BadgeDTO.class)).orElseThrow(() -> new ResourceException("Badge Not found"));
    }

    public BadgeDTO createNewBadge(BadgeRequestDTO badgeDTO) {
        if(badgeRepository.findByBadgeId(badgeDTO.getBadgeId()).isPresent()){
            throw new ResourceException("Badge Already Exists", HttpStatus.CONFLICT);
        }
        Member member = memberRepository.findById(badgeDTO.getMemberId()).orElseThrow(()->new ResourceException("Member Not found"));
        badgeRepository.updatePreviousBadges(member.getId());
        Badge badge = modelMapper.map(badgeDTO, Badge.class);
        badge.setStatus("ACTIVE");
        badge.setMember(member);
        Badge newBadge = badgeRepository.save(badge);
        return modelMapper.map(newBadge, BadgeDTO.class);
    }

    public BadgeDTO updateBadge(String id, BadgeRequestDTO badgeDTO) {
        Badge oldBadge = badgeRepository.findByBadgeId(id).orElseThrow(() -> new ResourceException("Badge Not found"));
        Member member = memberRepository.findById(badgeDTO.getMemberId()).orElseThrow(()->new ResourceException("Member Not found"));
        Badge badge = modelMapper.map(badgeDTO, Badge.class);
        badge.setId(oldBadge.getId());
        badge.setStatus(oldBadge.getStatus());
        badge.setMember(member);
        badge.setBadgeId(id);
        Badge updatedBadge = badgeRepository.save(badge);
        return modelMapper.map(updatedBadge, BadgeDTO.class);
    }

    public void deleteBadge(String id) {
        Badge badge = badgeRepository.findByBadgeId(id).orElseThrow(() -> new ResourceException("Badge Not found"));
        badgeRepository.delete(badge);
    }
}
