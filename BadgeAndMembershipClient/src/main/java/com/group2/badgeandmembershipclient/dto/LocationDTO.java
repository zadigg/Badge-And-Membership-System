package com.group2.badgeandmembershipclient.dto;

import com.group2.badgeandmembershipclient.enums.LocationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private List<TimeslotDTO> timeslots;
    public LocationDTO(String locationId, String name, String description, int capacity, LocationType locationType) {
        this.locationId = locationId;
        this.name = name;
        this.description = description;
        this.capacity = capacity;
        this.locationType = locationType;
    }

}
