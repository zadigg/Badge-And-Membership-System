package com.group2.badgeandmembershipsystem.service.impl;

import com.group2.badgeandmembershipsystem.domain.Member;
import com.group2.badgeandmembershipsystem.domain.Role;
import com.group2.badgeandmembershipsystem.dto.MemberDTO;
import com.group2.badgeandmembershipsystem.dto.MemberLoginResponseDTO;
import com.group2.badgeandmembershipsystem.dto.RoleDTO;
import com.group2.badgeandmembershipsystem.model.LoginRequest;
import com.group2.badgeandmembershipsystem.model.LoginResponse;
import com.group2.badgeandmembershipsystem.repository.MemberRepository;
import com.group2.badgeandmembershipsystem.security.JwtHelper;
import com.group2.badgeandmembershipsystem.security.MyUserDetails;
import com.group2.badgeandmembershipsystem.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private JwtHelper jwtHelper;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        Authentication result;
        try {
            result = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            log.info("Bad Credentials");
            throw e;
        } catch (Exception ex) {
            log.info(ex.getMessage());
            throw ex;
        }
        final String accessToken = jwtHelper.generateToken(loginRequest.getUsername(),
                new HashMap<String, Object>() {{
                    put("firstName", ((MyUserDetails) result.getPrincipal()).getFirstName());
                    put("lastName", ((MyUserDetails) result.getPrincipal()).getLastName());
                    put("sub", loginRequest.getUsername());
                    put("userId",((MyUserDetails) result.getPrincipal()).getId());
                    put("roles",mapRoles(((MyUserDetails) result.getPrincipal()).getRoles()));
                }}
        );
        Member member = memberRepository.findMemberByEmailAddressIgnoreCase(loginRequest.getUsername());
        MemberLoginResponseDTO memberDTO = modelMapper.map(member, MemberLoginResponseDTO.class);
        var loginResponse = new LoginResponse(accessToken,memberDTO);
        return loginResponse;
    }
    private List<RoleDTO> mapRoles(List<Role> roles)
    {
        return roles.stream().map(r->modelMapper.map(r,RoleDTO.class)).toList();
    }
}
