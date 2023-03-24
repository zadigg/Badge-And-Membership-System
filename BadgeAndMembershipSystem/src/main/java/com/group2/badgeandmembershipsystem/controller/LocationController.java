package com.group2.badgeandmembershipsystem.controller;

import com.group2.badgeandmembershipsystem.domain.enums.LocationType;
import com.group2.badgeandmembershipsystem.dto.LocationDTO;
import com.group2.badgeandmembershipsystem.exception.payload.ApiResponse;
import com.group2.badgeandmembershipsystem.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
public class LocationController {
    @Autowired
    private LocationService locationService;

    @GetMapping("/{locationId}")
    public ResponseEntity<LocationDTO> getLocation(@PathVariable String locationId){
        return ResponseEntity.status(HttpStatus.OK).body(locationService.getLocation(locationId));
    }
    @PostMapping
    public ResponseEntity<LocationDTO> addNewLocation(@RequestBody LocationDTO location){
        return ResponseEntity.status(HttpStatus.OK).body(locationService.addLocation(location));
    }
    @PutMapping("/{locationId}")
    public ResponseEntity<LocationDTO> updateLocation(@PathVariable String locationId,@RequestBody LocationDTO location){
        return ResponseEntity.status(HttpStatus.OK).body(locationService.updateLocation(locationId,location));
    }
    @DeleteMapping("/{locationId}")
    public ResponseEntity<ApiResponse> deleteLocation(@PathVariable String locationId) {
        locationService.deleteLocation(locationId);
        ApiResponse response = ApiResponse.builder().message("Location is deleted successfully").success(true).status(HttpStatus.OK).build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @GetMapping
    public ResponseEntity<List<LocationDTO>> getAllLocations(){
        return ResponseEntity.status(HttpStatus.OK).body(locationService.findAll());
    }
    @GetMapping("/filterBy")
    public ResponseEntity<List<LocationDTO>> getLocationByType(@RequestParam LocationType locationType){
        return ResponseEntity.status(HttpStatus.OK).body(locationService.getLocationsByType(locationType));
    }
}
