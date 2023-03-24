package com.group2.badgeandmembershipsystem.repository;

import com.group2.badgeandmembershipsystem.domain.Membership;
import com.group2.badgeandmembershipsystem.dto.MembershipDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MembershipRepository extends JpaRepository<Membership,Long> {
}
