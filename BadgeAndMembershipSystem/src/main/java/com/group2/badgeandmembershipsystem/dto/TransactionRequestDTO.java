package com.group2.badgeandmembershipsystem.dto;

import com.group2.badgeandmembershipsystem.domain.Badge;
import com.group2.badgeandmembershipsystem.domain.Location;
import com.group2.badgeandmembershipsystem.domain.Plan;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequestDTO {
    private long id;
    private LocalDateTime dateTime;
    private long planId;
    private String locationId;
    private String badgeId;
}
