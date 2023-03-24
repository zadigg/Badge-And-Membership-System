package com.group2.badgeandmembershipsystem.controller;

import com.group2.badgeandmembershipsystem.dto.LocationDTO;
import com.group2.badgeandmembershipsystem.dto.PlanDTO;
import com.group2.badgeandmembershipsystem.dto.PlanRequestDTO;
import com.group2.badgeandmembershipsystem.exception.payload.ApiResponse;
import com.group2.badgeandmembershipsystem.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plans")
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
public class PlanController {
    @Autowired
    private PlanService planService;

    @PostMapping
    public ResponseEntity<PlanDTO> addNewPlan(@RequestBody PlanRequestDTO plan){
        return ResponseEntity.status(HttpStatus.OK).body(planService.addNewPlan(plan));
    }

    @GetMapping
    public ResponseEntity<List<PlanDTO>> getAllPlans(){
        return ResponseEntity.status(HttpStatus.OK).body(planService.getAllPlans());
    }

    @GetMapping("/{planId}")
    public ResponseEntity<PlanDTO> getPlan(@PathVariable Long planId){
        return ResponseEntity.status(HttpStatus.OK).body(planService.getPlan(planId));
    }

    @PutMapping("/{planId}")
    public ResponseEntity<PlanDTO> updatePlan(@PathVariable Long planId, @RequestBody PlanRequestDTO plan){
        return ResponseEntity.status(HttpStatus.OK).body(planService.updatePlan(planId,plan));
    }

    @DeleteMapping("{planId}")
    public ResponseEntity<ApiResponse> deletePlan(@PathVariable Long planId){
        planService.removePlan(planId);
        ApiResponse response = ApiResponse.builder().message("Plan is deleted successfully").success(true).status(HttpStatus.OK).build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @GetMapping("/{planId}/locations")
    public ResponseEntity<List<LocationDTO>> getLocationsOfPlan(@PathVariable Long planId){
        return ResponseEntity.status(HttpStatus.OK).body(planService.getLocationsByPlan(planId));
    }
}
