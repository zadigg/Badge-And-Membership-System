package com.group2.badgeandmembershipclient.dto;

import lombok.Data;

@Data
public class PasswordDTO {
    private String newPassword;
    private String verifyNewPassword;
}
