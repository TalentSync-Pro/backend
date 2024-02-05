package com.example.TalentSyncpro.Config;

import com.example.TalentSyncpro.Models.Admin;
import com.example.TalentSyncpro.Models.BaseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class UserInfoUserDetails implements UserDetails {

    private String username;
    private String password;

    private List<GrantedAuthority> authorities;
    public UserInfoUserDetails(BaseEntity user) {
        this.username = user.getUsername();
        this.password = user.getPassword();

        this.authorities = new ArrayList<>();

        String roles = user.getRole();
        String[] rolesArray = roles.split(",");

        for(String role : rolesArray){
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role);
            this.authorities.add(grantedAuthority);
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
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
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
