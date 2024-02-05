package com.example.TalentSyncpro.Service;

import com.example.TalentSyncpro.DTOs.RequestDto.AdminRequestDto;
import com.example.TalentSyncpro.DTOs.RequestDto.AuthRequest;
import com.example.TalentSyncpro.Models.Admin;
import com.example.TalentSyncpro.Repository.AdminRepository;
import com.example.TalentSyncpro.Transformers.AdminTransformer;
import com.example.TalentSyncpro.Transformers.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AdminService {
    @Autowired
    private  AdminRepository adminRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String createAdmin(AdminRequestDto adminDto) {

        Admin newAdmin = AdminTransformer.convertDtoToEntity(adminDto);
        newAdmin.setUuid(UserTransformer.generateRandomUuid());
        newAdmin.setPassword(passwordEncoder.encode(newAdmin.getPassword()));

        adminRepository.save(newAdmin);

        return "New Admin created Successfully";
    }

}
