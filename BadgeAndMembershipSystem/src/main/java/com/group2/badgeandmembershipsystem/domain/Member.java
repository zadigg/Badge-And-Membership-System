package com.group2.badgeandmembershipsystem.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "member")
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String emailAddress;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "member_role")
    private List<Role> roles = new ArrayList<>();
    @OneToMany(mappedBy = "member")
    private List<Badge> badges = new ArrayList<>();
    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "member")
    private List<Membership> memberships = new ArrayList<>();

    public Member(String firstName, String lastName, String emailAddress, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.password = password;
    }
}
