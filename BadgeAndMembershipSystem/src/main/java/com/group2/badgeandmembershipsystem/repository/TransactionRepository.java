package com.group2.badgeandmembershipsystem.repository;

import com.group2.badgeandmembershipsystem.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    @Query("select t from Transaction t where t.badge.badgeId=:badgeId")
    List<Transaction> findByBadgeId(String badgeId);
    @Query("select count(t) from Transaction t where t.badge.badgeId=:badgeId and t.transactionType = 'ACCEPTED' and t.dateTime between :startDateTime and :endDateTime")
    int countAcceptedByLocationIdAndTimeInBetween(String badgeId, LocalDateTime startDateTime, LocalDateTime endDateTime);
}
