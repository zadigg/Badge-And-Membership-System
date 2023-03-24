package com.group2.badgeandmembershipsystem.service;

import com.group2.badgeandmembershipsystem.domain.enums.MembershipType;
import com.group2.badgeandmembershipsystem.dto.MembershipDTO;
import com.group2.badgeandmembershipsystem.dto.MembershipRequestDTO;

import java.util.List;

public interface MembershipService {
    MembershipDTO createNewMembership(MembershipRequestDTO membershipDTO);
    MembershipDTO updateMembership(long id, MembershipRequestDTO membershipDTO);
    void deleteMembership(long id);
    MembershipDTO getMembership(long id);
    List<MembershipDTO> getAllMemberships();
}
