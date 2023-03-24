package com.group2.badgeandmembershipsystem.domain;

import com.group2.badgeandmembershipsystem.domain.enums.MembershipType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "membership")
@AllArgsConstructor
@NoArgsConstructor
public class Membership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate startDate;
    private LocalDate endDate;
    @Enumerated(EnumType.STRING)
    private MembershipType membershipType;
    @Column(nullable = false)
    private int numberOfAllowances;
    @ManyToOne
    @JoinColumn(name = "planId",nullable = false)
    private Plan plan;

    public Membership(LocalDate startDate, LocalDate endDate, MembershipType membershipType, int numberOfAllowances) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.membershipType = membershipType;
        this.numberOfAllowances = numberOfAllowances;
    }
}
