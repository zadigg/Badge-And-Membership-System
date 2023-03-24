package com.group2.badgeandmembershipclient.dto;

import lombok.Data;


@Data
public class RegistrationMessageDTO {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;
//    private List<RoleDTO> roles = new ArrayList<>();
//    private List<BadgeDTO> badges = new ArrayList<>();
//    private List<MembershipDTO> memberships = new ArrayList<>();
}
