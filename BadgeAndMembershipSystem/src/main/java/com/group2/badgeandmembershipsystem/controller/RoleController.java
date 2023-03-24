package com.group2.badgeandmembershipsystem.controller;

import com.group2.badgeandmembershipsystem.dto.RoleDTO;
import com.group2.badgeandmembershipsystem.exception.payload.ApiResponse;
import com.group2.badgeandmembershipsystem.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @GetMapping
    public ResponseEntity<List<RoleDTO>> getAllRoles(){
        return ResponseEntity.status(HttpStatus.OK).body(roleService.getAllRoles());
    }
    @GetMapping("/{id}")
    public ResponseEntity<RoleDTO> getRole(@PathVariable long id){
        return ResponseEntity.status(HttpStatus.OK).body(roleService.getRole(id));
    }
    @PostMapping
    public ResponseEntity<RoleDTO> addNewRole(@RequestBody RoleDTO role){
        return ResponseEntity.status(HttpStatus.OK).body(roleService.createNewRole(role));
    }
    @PutMapping("/{id}")
    public ResponseEntity<RoleDTO> updateRole(@PathVariable long id, @RequestBody RoleDTO role){
        return ResponseEntity.status(HttpStatus.OK).body(roleService.updateRole(id,role));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteRole(@PathVariable long id){
        roleService.deleteRole(id);
        ApiResponse response = ApiResponse.builder().message("Role is deleted successfully").success(true).status(HttpStatus.OK).build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
