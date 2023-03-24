package com.group2.badgeandmembershipsystem.service;

import com.group2.badgeandmembershipsystem.dto.RoleDTO;

import java.util.List;

public interface RoleService {
    RoleDTO createNewRole(RoleDTO role);
    List<RoleDTO> getAllRoles();
    RoleDTO getRole(long id);
    void deleteRole(long id);
    RoleDTO updateRole(long id, RoleDTO role);
}
