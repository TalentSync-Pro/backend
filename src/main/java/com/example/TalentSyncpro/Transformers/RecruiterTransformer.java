package com.example.TalentSyncpro.Transformers;

import com.example.TalentSyncpro.DTOs.RequestDto.AdminRequestDto;
import com.example.TalentSyncpro.DTOs.RequestDto.ClientRequestDto;
import com.example.TalentSyncpro.DTOs.RequestDto.RecruiterRequestDto;
import com.example.TalentSyncpro.Models.Admin;
import com.example.TalentSyncpro.Models.Recruiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class RecruiterTransformer {


    public static Recruiter convertDtoToEntity(RecruiterRequestDto dto){
        Recruiter user = new Recruiter();

        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setRole(dto.getRole());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());

        return user;
    }
}
