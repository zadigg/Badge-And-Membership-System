package com.group2.badgeandmembershipsystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "badge")
@AllArgsConstructor
@NoArgsConstructor
public class Badge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String status;
    @Column(unique = true)
    private String badgeId;
    @ManyToOne
    @JoinColumn(name = "member",nullable = false)
    private Member member;

//    @OneToMany(mappedBy = "badge")
//    private List<Transaction> transactions = new ArrayList<>();

    public Badge(String name, String status, String badgeId) {
        this.name = name;
        this.status = status;
        this.badgeId = badgeId;
    }
}
