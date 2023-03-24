package com.group2.badgeandmembershipsystem.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberLoginResponseDTO {
    private long id;
    private String firstName;
    private String lastName;
    private String emailAddress;
}
