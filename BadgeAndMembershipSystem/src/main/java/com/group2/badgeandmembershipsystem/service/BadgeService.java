package com.group2.badgeandmembershipsystem.service;

import com.group2.badgeandmembershipsystem.dto.BadgeDTO;
import com.group2.badgeandmembershipsystem.dto.BadgeRequestDTO;

import java.util.List;

public interface BadgeService {
    List<BadgeDTO> findAll();

    BadgeDTO createNewBadge(BadgeRequestDTO badgeDTO);

    void deleteBadge(String id);

    BadgeDTO findById(String id);

    BadgeDTO updateBadge(String id, BadgeRequestDTO badgeDTO);
}
