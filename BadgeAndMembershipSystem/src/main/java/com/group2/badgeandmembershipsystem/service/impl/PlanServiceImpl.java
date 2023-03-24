package com.group2.badgeandmembershipsystem.service.impl;

import com.group2.badgeandmembershipsystem.domain.Location;
import com.group2.badgeandmembershipsystem.domain.Plan;
import com.group2.badgeandmembershipsystem.domain.Role;
import com.group2.badgeandmembershipsystem.dto.LocationDTO;
import com.group2.badgeandmembershipsystem.dto.PlanDTO;
import com.group2.badgeandmembershipsystem.dto.PlanRequestDTO;
import com.group2.badgeandmembershipsystem.exception.ResourceException;
import com.group2.badgeandmembershipsystem.repository.LocationRepository;
import com.group2.badgeandmembershipsystem.repository.PlanRepository;
import com.group2.badgeandmembershipsystem.repository.RoleRepository;
import com.group2.badgeandmembershipsystem.service.PlanService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PlanServiceImpl implements PlanService {
    @Autowired
    private PlanRepository planRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PlanDTO addNewPlan(PlanRequestDTO planDTO) {
        Plan plan = modelMapper.map(planDTO, Plan.class);
        List<Role> roles = planDTO.getAllowedRoles().stream().map(role -> roleRepository.findByNameIgnoreCase(role.getName())).collect(Collectors.toList());
        plan.setAllowedRoles(roles);
        List<Location> locations = planDTO.getLocationIds().stream().map(locationId->locationRepository.findByLocationIdIgnoreCase(locationId)).collect(Collectors.toList());
        plan.setLocations(locations);
        Plan newPlan = planRepository.save(plan);
        return modelMapper.map(newPlan, PlanDTO.class);
    }

    @Override
    public PlanDTO getPlan(Long planId) {
        return planRepository.findById(planId).map(plan -> modelMapper.map(plan, PlanDTO.class)).orElseThrow(() -> new ResourceException("Plan Not found"));
    }

    @Override
    public List<PlanDTO> getAllPlans() {
        List<Plan> plans = planRepository.findAll();
        return plans.stream().map(plan -> modelMapper.map(plan, PlanDTO.class)).collect(Collectors.toList());
    }

    @Override
    public PlanDTO updatePlan(Long planId, PlanRequestDTO planDTO) {
        Plan oldPlan = planRepository.findById(planId).orElseThrow(()->new ResourceException("Plan Not found"));
        Plan plan = modelMapper.map(planDTO,Plan.class);
        List<Role> roles = planDTO.getAllowedRoles().stream().map(role -> roleRepository.findByNameIgnoreCase(role.getName())).collect(Collectors.toList());
        plan.setAllowedRoles(roles);
        List<Location> locations = planDTO.getLocationIds().stream().map(locationId->locationRepository.findByLocationIdIgnoreCase(locationId)).collect(Collectors.toList());
        plan.setLocations(locations);
        plan.setId(oldPlan.getId());
        Plan updatedPlan = planRepository.save(plan);
        return modelMapper.map(updatedPlan, PlanDTO.class);
    }

    @Override
    public void removePlan(Long planId) {
        Plan plan = planRepository.findById(planId).orElseThrow(() -> new ResourceException("Plan Not found"));
        planRepository.delete(plan);
    }

    @Override
    public List<LocationDTO> getLocationsByPlan(long planId) {
        List<Location> locations = planRepository.findLocationsById(planId);
        if (locations.isEmpty()){
            throw new ResourceException("No locations under the given plan");
        }
        return locations.stream().map(location -> modelMapper.map(location, LocationDTO.class)).collect(Collectors.toList());
    }
}
