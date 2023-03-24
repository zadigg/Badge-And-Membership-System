package com.group2.badgeandmembershipsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeslotDTO {
    private long id;
    private LocalTime startTime;
    private LocalTime endTime;
    private String dayOfTheWeek;
//    private LocationDTO location;
}
