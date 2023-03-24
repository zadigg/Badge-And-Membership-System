package com.group2.badgeandmembershipsystem.service.impl;

import com.group2.badgeandmembershipsystem.domain.Role;
import com.group2.badgeandmembershipsystem.dto.RoleDTO;
import com.group2.badgeandmembershipsystem.exception.ResourceException;
import com.group2.badgeandmembershipsystem.repository.RoleRepository;
import com.group2.badgeandmembershipsystem.service.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public RoleDTO createNewRole(RoleDTO roleDTO) {
        Role role = modelMapper.map(roleDTO, Role.class);
        Role newRole = roleRepository.save(role);
        return modelMapper.map(newRole,RoleDTO.class);
    }

    @Override
    public List<RoleDTO> getAllRoles() {
        return roleRepository.findAll().stream().map(role -> modelMapper.map(role,RoleDTO.class)).toList();
    }

    @Override
    public RoleDTO getRole(long id) {
        return roleRepository.findById(id).map(role -> modelMapper.map(role,RoleDTO.class)).orElseThrow(()->new ResourceException("Role Not found"));
    }

    @Override
    public void deleteRole(long id) {
        Role role = roleRepository.findById(id).orElseThrow(()->new ResourceException("Role Not found"));
        roleRepository.delete(role);
    }

    @Override
    public RoleDTO updateRole(long id, RoleDTO roleDTO) {
        roleRepository.findById(id).orElseThrow(()->new ResourceException("Role Not found"));
        Role role = modelMapper.map(roleDTO,Role.class);
        role.setId(id);
        Role updatedRole = roleRepository.save(role);
        return modelMapper.map(updatedRole, RoleDTO.class);
    }
}