package com.group2.badgeandmembershipsystem.service;

import com.group2.badgeandmembershipsystem.dto.LocationDTO;
import com.group2.badgeandmembershipsystem.dto.PlanDTO;
import com.group2.badgeandmembershipsystem.dto.PlanRequestDTO;

import java.util.List;

public interface PlanService {
     PlanDTO addNewPlan(PlanRequestDTO plan);
     List<PlanDTO> getAllPlans();
     PlanDTO getPlan(Long planId);
     PlanDTO updatePlan(Long planId, PlanRequestDTO plan);
     void removePlan(Long planId);
     List<LocationDTO> getLocationsByPlan(long planId);

}
