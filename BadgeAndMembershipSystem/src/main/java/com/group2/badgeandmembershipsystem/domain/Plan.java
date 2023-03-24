package com.group2.badgeandmembershipsystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "plans")
@AllArgsConstructor
@NoArgsConstructor
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Lob
    @Column(length = 4000)
    private String description;
    @ManyToMany
    @JoinTable(name = "plan_role")
    private List<Role> allowedRoles = new ArrayList<>();
    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(name = "plan_location")
    private List<Location> locations = new ArrayList<>();

    public Plan(String name, String description){
        this.name = name;
        this.description = description;
    }
}
