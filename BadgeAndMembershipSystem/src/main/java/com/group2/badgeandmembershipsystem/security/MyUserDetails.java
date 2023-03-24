package com.group2.badgeandmembershipsystem.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.group2.badgeandmembershipsystem.domain.Member;
import com.group2.badgeandmembershipsystem.domain.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Locale;

public class MyUserDetails implements UserDetails {
    private long id;
    private String username;
    private String firstName;
    private String lastName;
    @JsonIgnore
    private String  password;
    private List<Role> roles;

    public MyUserDetails(Member user){
        this.id = user.getId();
        this.username = user.getEmailAddress();
        this.password = user.getPassword();
        this.roles = user.getRoles();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        var result = roles.stream()
                .map(role-> new SimpleGrantedAuthority("ROLE_"+role.getName().toUpperCase(Locale.ROOT)))
                .toList();
        return result;
    }

    public long getId() {
        return id;
    }
    public List<Role> getRoles() {
        return roles;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
