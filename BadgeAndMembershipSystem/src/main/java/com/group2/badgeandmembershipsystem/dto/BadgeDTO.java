package com.group2.badgeandmembershipsystem.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BadgeDTO {
    private String name;
    private String status;
    private String badgeId;

    public BadgeDTO(String name, String status, String badgeId) {
        this.name = name;
        this.status = status;
        this.badgeId = badgeId;
    }
}
