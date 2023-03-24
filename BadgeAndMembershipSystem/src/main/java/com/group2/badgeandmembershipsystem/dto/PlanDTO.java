package com.group2.badgeandmembershipsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanDTO {
    private long id;
    private String name;
    private String description;
    private List<RoleDTO> allowedRoles = new ArrayList<>();
    private List<LocationDTO> locations = new ArrayList<>();

    public PlanDTO(String name, String description){
        this.name = name;
        this.description = description;
    }
}
