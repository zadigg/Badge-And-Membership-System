package com.group2.badgeandmembershipsystem.controller;

import com.group2.badgeandmembershipsystem.dto.BadgeDTO;
import com.group2.badgeandmembershipsystem.dto.BadgeRequestDTO;
import com.group2.badgeandmembershipsystem.exception.payload.ApiResponse;
import com.group2.badgeandmembershipsystem.service.BadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/badges")
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
public class BadgeController {
    @Autowired
    private BadgeService badgeService;
    @GetMapping
    public ResponseEntity<List<BadgeDTO>> getAllBadges() {
        return ResponseEntity.status(HttpStatus.OK).body(badgeService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<BadgeDTO> findById(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(badgeService.findById(id));
    }
    @PostMapping
    public ResponseEntity<BadgeDTO> createBadge(@RequestBody BadgeRequestDTO badge) {
        return ResponseEntity.status(HttpStatus.OK).body(badgeService.createNewBadge(badge));
    }
    @PutMapping("/{id}")
    public ResponseEntity<BadgeDTO> updateBadge(@PathVariable String id, @RequestBody BadgeRequestDTO badge) {
        return ResponseEntity.status(HttpStatus.OK).body(badgeService.updateBadge(id,badge));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteBadge(@PathVariable String id) {
        badgeService.deleteBadge(id);
        ApiResponse response = ApiResponse.builder().message("Badge is deleted successfully").success(true).status(HttpStatus.OK).build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
