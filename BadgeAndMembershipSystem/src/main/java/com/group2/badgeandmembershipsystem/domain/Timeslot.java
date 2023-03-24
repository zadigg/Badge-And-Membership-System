package com.group2.badgeandmembershipsystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "time_slot")
@AllArgsConstructor
@NoArgsConstructor
public class Timeslot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalTime startTime;
    private LocalTime endTime;
    private String dayOfTheWeek;

}
