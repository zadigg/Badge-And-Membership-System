package com.group2.badgeandmembershipsystem.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class MemberDTO {
    private long id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private List<RoleDTO> roles = new ArrayList<>();
    private List<BadgeDTO> badges = new ArrayList<>();
    private List<MembershipDTO> memberships = new ArrayList<>();

    public MemberDTO(String firstName, String lastName, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
    }
}
