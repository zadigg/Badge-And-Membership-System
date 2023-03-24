package com.group2.badgeandmembershipsystem.dto;

import com.group2.badgeandmembershipsystem.domain.enums.LocationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationDTO {
    private long id;
    private String locationId;
    private String name;
    private String description;
    private int capacity;
    private LocationType locationType;
    private List<TimeslotDTO> timeslots = new ArrayList<>();
    public LocationDTO(String locationId, String name, String description, int capacity, LocationType locationType) {
        this.locationId = locationId;
        this.name = name;
        this.description = description;
        this.capacity = capacity;
        this.locationType = locationType;
    }

}
