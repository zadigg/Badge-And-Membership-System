package com.group2.badgeandmembershipsystem.service;

import com.group2.badgeandmembershipsystem.model.LoginRequest;
import com.group2.badgeandmembershipsystem.model.LoginResponse;

public interface UserService {
    LoginResponse login(LoginRequest loginRequest);
}
