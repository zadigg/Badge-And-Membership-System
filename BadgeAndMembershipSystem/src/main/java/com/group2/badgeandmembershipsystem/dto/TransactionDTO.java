package com.group2.badgeandmembershipsystem.dto;

import com.group2.badgeandmembershipsystem.domain.Badge;
import com.group2.badgeandmembershipsystem.domain.Location;
import com.group2.badgeandmembershipsystem.domain.Plan;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO {
    private long id;
    private LocalDateTime dateTime;
    private String transactionType;
    private PlanDTO plan;
    private LocationDTO location;
    private BadgeDTO badge;

    public TransactionDTO(LocalDateTime dateTime, String transactionType) {
        this.dateTime = dateTime;
        this.transactionType = transactionType;
    }
}
