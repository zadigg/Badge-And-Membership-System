package com.group2.badgeandmembershipsystem.controller;

import com.group2.badgeandmembershipsystem.dto.MembershipDTO;
import com.group2.badgeandmembershipsystem.dto.MembershipRequestDTO;
import com.group2.badgeandmembershipsystem.exception.payload.ApiResponse;
import com.group2.badgeandmembershipsystem.service.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/memberships")
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
public class MembershipController {
    @Autowired
    private MembershipService membershipService;
    @PostMapping
    public ResponseEntity<MembershipDTO> addNewMembership(@RequestBody MembershipRequestDTO membership){
        return ResponseEntity.status(HttpStatus.OK).body(membershipService.createNewMembership(membership));
    }

    @GetMapping
    public ResponseEntity<List<MembershipDTO>> getAllMemberships(){
        return ResponseEntity.status(HttpStatus.OK).body(membershipService.getAllMemberships());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MembershipDTO> getMembership(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(membershipService.getMembership(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MembershipDTO> updateMembership(@PathVariable Long id, @RequestBody MembershipRequestDTO membership){
        return ResponseEntity.status(HttpStatus.OK).body(membershipService.updateMembership(id,membership));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponse> deleteMembership(@PathVariable Long id){
        membershipService.deleteMembership(id);
        ApiResponse response = ApiResponse.builder().message("Membership is deleted successfully").success(true).status(HttpStatus.OK).build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
