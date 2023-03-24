package com.group2.badgeandmembershipsystem.service;

import com.group2.badgeandmembershipsystem.domain.enums.LocationType;
import com.group2.badgeandmembershipsystem.dto.LocationDTO;

import java.util.List;

public interface LocationService {

    LocationDTO getLocation(String locationId);

    LocationDTO addLocation(LocationDTO location);

    void deleteLocation(String locationId);

    LocationDTO updateLocation(String locationId, LocationDTO location);

    List<LocationDTO> findAll();

    List<LocationDTO> getLocationsByType(LocationType locationType);


}
