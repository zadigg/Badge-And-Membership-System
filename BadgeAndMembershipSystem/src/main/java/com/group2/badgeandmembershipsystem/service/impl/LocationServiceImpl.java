package com.group2.badgeandmembershipsystem.service.impl;

import com.group2.badgeandmembershipsystem.domain.Location;
import com.group2.badgeandmembershipsystem.domain.enums.LocationType;
import com.group2.badgeandmembershipsystem.dto.LocationDTO;
import com.group2.badgeandmembershipsystem.exception.ResourceException;
import com.group2.badgeandmembershipsystem.repository.LocationRepository;
import com.group2.badgeandmembershipsystem.service.LocationService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class LocationServiceImpl implements LocationService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public LocationDTO getLocation(String locationId) {
        log.info("Inside getLocation of LocationService");
        return locationRepository.findByLocationId(locationId).map(location -> modelMapper.map(location, LocationDTO.class)).orElseThrow(()->new ResourceException("Location Not found"));
    }

    @Override
    public LocationDTO addLocation(LocationDTO locationDTO) {
        log.info("inside addLocation of Location Service");
        Optional<Location> toBeAdded = locationRepository.findByLocationId(locationDTO.getLocationId());
        if(toBeAdded.isPresent()){
            throw new ResourceException("Location is already present", HttpStatus.CONFLICT);
        }
        Location location = modelMapper.map(locationDTO,Location.class);
        Location newLocation = locationRepository.save(location);
        return modelMapper.map(newLocation,LocationDTO.class);
    }

    @Override
    public void deleteLocation(String locationId) {
        log.info("inside deleteLocation of LocationService");
        Location location1 = locationRepository.findByLocationId(locationId).orElseThrow(()->new ResourceException("Location Not found"));
        locationRepository.delete(location1);
    }

    @Override
    public LocationDTO updateLocation(String locationId, LocationDTO locationDTO) {
        log.info("inside updateLocation of Location Service");
        Location oldLocation = locationRepository.findByLocationId(locationId).orElseThrow(()->new ResourceException("Location Not found"));
        Location location = modelMapper.map(locationDTO,Location.class);
        location.setId(oldLocation.getId());
        location.setLocationId(locationId);
        location.setName(location.getName());
        location.setLocationType(location.getLocationType());
        location.setCapacity(location.getCapacity());
        location.setDescription(location.getDescription());
        location.setTimeslots(location.getTimeslots());
        Location updatedLocation = locationRepository.save(location);
        return modelMapper.map(updatedLocation, LocationDTO.class);
    }

    @Override
    public List<LocationDTO> findAll() {
        log.info("inside findAll of LocationService");
        List<Location> locationList = locationRepository.findAll();
        return locationList.stream().map(location -> modelMapper.map(location,LocationDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<LocationDTO> getLocationsByType(LocationType locationType) {
        log.info("inside getLocationsByType of Location Service");
        List<Location> locationList = locationRepository.findByLocationType(locationType);
        if (locationList.isEmpty()){
            throw new ResourceException("No any locations for the given type");
        }
        return locationList.stream().map(location -> modelMapper.map(location,LocationDTO.class)).collect(Collectors.toList());
    }
}
