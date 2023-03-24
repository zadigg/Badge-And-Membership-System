package com.group2.badgeandmembershipclient.dto;

import com.group2.badgeandmembershipclient.enums.MembershipType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MembershipDTO {
    private long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private MembershipType membershipType;
    private int numberOfAllowances;
    private PlanDTO plan;
    public MembershipDTO(LocalDate startDate, LocalDate endDate, MembershipType membershipType, int numberOfAllowances){
        this.startDate = startDate;
        this.endDate = endDate;
        this.membershipType = membershipType;
        this.numberOfAllowances = numberOfAllowances;
    }
}
