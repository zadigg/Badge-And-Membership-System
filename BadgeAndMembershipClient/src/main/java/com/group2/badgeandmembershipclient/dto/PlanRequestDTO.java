package com.group2.badgeandmembershipclient.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanRequestDTO {
    private long id;
    private String name;
    private String description;
    private List<RoleDTO> allowedRoles = new ArrayList<>();
    private List<MembershipDTO> memberships = new ArrayList<>();
    private List<String> locationIds = new ArrayList<>();

    public PlanRequestDTO(String name, String description){
        this.name = name;
        this.description = description;
    }
}
