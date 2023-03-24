package com.group2.badgeandmembershipclient.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MembershipsDTO {
    private List<MembershipDTO> memberships;

}
