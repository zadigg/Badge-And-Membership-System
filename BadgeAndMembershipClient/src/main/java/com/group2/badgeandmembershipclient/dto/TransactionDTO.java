package com.group2.badgeandmembershipclient.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
