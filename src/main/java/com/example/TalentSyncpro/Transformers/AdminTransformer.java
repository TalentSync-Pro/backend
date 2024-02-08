package com.example.TalentSyncpro.Transformers;

import com.example.TalentSyncpro.DTOs.RequestDto.AdminRequestDto;
import com.example.TalentSyncpro.DTOs.RequestDto.RecruiterRequestDto;
import com.example.TalentSyncpro.Models.Admin;
import com.example.TalentSyncpro.Models.Recruiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AdminTransformer {

    public static Admin convertDtoToEntity(AdminRequestDto dto){
        Admin user = new Admin();

        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setRole(dto.getRole());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());

        return user;
    }

}
