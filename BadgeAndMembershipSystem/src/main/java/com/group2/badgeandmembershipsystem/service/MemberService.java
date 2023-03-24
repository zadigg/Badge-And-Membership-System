package com.group2.badgeandmembershipsystem.service;


import com.group2.badgeandmembershipsystem.domain.enums.MembershipType;
import com.group2.badgeandmembershipsystem.dto.*;

import java.util.List;

public interface MemberService {

    MemberDTO createNewMember(RegistrationDTO memberDTO);
    MemberDTO updateMember(long id, UpdateMemberDTO memberDTO);
    void deleteMember(long id);
    MemberDTO getMember(long id);
    List<MemberDTO> getAllMembers();
    void changePassword(long id, PasswordDTO passwordDTO);
    List<TransactionDTO> findTransactionsByMemberId(long memberId);
    List<PlanDTO> findPlansByMemberId(long memberId);
    List<BadgeDTO> findBadgesByMemberId(long memberId);
    List<BadgeDTO> filterActiveBadgesOfMember(long memberId, String status);
    List<MembershipDTO> findMembershipsByMemberId(long memberId);
    List<MembershipDTO> getAllCheckerMemberships(long memberId, String membershipType);


}
