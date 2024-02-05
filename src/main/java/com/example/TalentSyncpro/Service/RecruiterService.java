package com.example.TalentSyncpro.Service;

import com.example.TalentSyncpro.DTOs.RequestDto.RecruiterRequestDto;
import com.example.TalentSyncpro.Models.Recruiter;
import com.example.TalentSyncpro.Repository.RecruiterRepository;
import com.example.TalentSyncpro.Transformers.RecruiterTransformer;
import com.example.TalentSyncpro.Transformers.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RecruiterService {
    @Autowired
    private RecruiterRepository recruiterRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String addRecruiter(RecruiterRequestDto recruiterRequestDto) {

        Recruiter recruiter = RecruiterTransformer.convertDtoToEntity(recruiterRequestDto);

        recruiter.setUuid(UserTransformer.generateRandomUuid());
        recruiter.setPassword(passwordEncoder.encode(recruiter.getPassword()));

        recruiterRepository.save(recruiter);
        return "Recruiter Created successfully";
    }

    private Recruiter convertDtoToEntity(RecruiterRequestDto dto){
        Recruiter user = new Recruiter();

        user.setUsername(dto.getUsername());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRole(dto.getRole());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());

        return user;
    }
}
