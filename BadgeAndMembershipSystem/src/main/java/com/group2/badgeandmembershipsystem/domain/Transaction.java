package com.group2.badgeandmembershipsystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "transactions")
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDateTime dateTime;
    private String transactionType;

    @ManyToOne
    @JoinColumn(name = "planId")
    private Plan plan;
    @ManyToOne
    @JoinColumn(name = "locationId")
    private Location location;
    @ManyToOne
    @JoinColumn(name = "badgeId")
    private Badge badge;

    public Transaction(LocalDateTime dateTime, String transactionType) {
        this.dateTime = dateTime;
        this.transactionType = transactionType;
    }
}
