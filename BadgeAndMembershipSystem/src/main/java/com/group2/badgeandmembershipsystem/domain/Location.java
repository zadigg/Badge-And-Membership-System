package com.group2.badgeandmembershipsystem.domain;

import com.group2.badgeandmembershipsystem.domain.enums.LocationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "location")
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String locationId;

    @Column(nullable = false)
    private String name;

    @Lob
    private String description;

    @Column(nullable = false)
    private int capacity;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private LocationType locationType;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "locationId")
    private List<Timeslot> timeslots = new ArrayList<>();

    public Location(String locationId, String name, String description, int capacity, LocationType locationType) {
        this.locationId = locationId;
        this.name = name;
        this.description = description;
        this.capacity = capacity;
        this.locationType = locationType;
    }
}
