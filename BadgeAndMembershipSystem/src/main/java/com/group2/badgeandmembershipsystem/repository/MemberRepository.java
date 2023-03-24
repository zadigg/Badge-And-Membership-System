package com.group2.badgeandmembershipsystem.repository;

import com.group2.badgeandmembershipsystem.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findMemberByEmailAddressIgnoreCase(String email);
    @Query("select t from Transaction t join t.badge b where b.member.id=:memberId")
    List<Transaction> findTransactionsByMemberId(long memberId);
    @Query("select p from Member m join m.memberships ms join ms.plan p where m.id=:memberId")
    List<Plan> findPlansByMemberId(long memberId);
    @Query("select m.badges from Member m  where m.id=:memberId")
    List<Badge> findBadgesByMemberId(long memberId);
    @Query("select m.badges from Member m  where m.id=:memberId")
    List<Badge> filterBadgesOfMember(long memberId);
    @Query("select m.memberships from Member m where m.id=:memberId")
    List<Membership> findMembershipsByMemberId(long memberId);
}
