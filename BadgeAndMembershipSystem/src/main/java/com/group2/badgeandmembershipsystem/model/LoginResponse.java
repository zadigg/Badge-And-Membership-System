package com.group2.badgeandmembershipsystem.model;

import com.group2.badgeandmembershipsystem.dto.MemberDTO;
import com.group2.badgeandmembershipsystem.dto.MemberLoginResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
    private String accessToken;
    private MemberLoginResponseDTO member;
}
