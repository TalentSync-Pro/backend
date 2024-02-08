package com.example.TalentSyncpro.Config;

import com.example.TalentSyncpro.Models.Admin;
import com.example.TalentSyncpro.Models.BaseEntity;
import com.example.TalentSyncpro.Models.Client;
import com.example.TalentSyncpro.Models.Recruiter;
import com.example.TalentSyncpro.Repository.AdminRepository;
import com.example.TalentSyncpro.Repository.ClientRepository;
import com.example.TalentSyncpro.Repository.RecruiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private RecruiterRepository recruiterRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        BaseEntity user = null;

        Optional<Admin> adminOptional = adminRepository.findByUsername(username);
        if (adminOptional.isPresent()) {
            user = adminOptional.get();
        } else {
            Optional<Client> clientOptional = clientRepository.findByUsername(username);
            if (clientOptional.isPresent()) {
                user = clientOptional.get();
            } else {
                Optional<Recruiter> recruiterOptional = recruiterRepository.findByUsername(username);
                if (recruiterOptional.isPresent()) {
                    user = recruiterOptional.get();
                } else {
                    throw new UsernameNotFoundException("User not found with username: " + username);
                }
            }
        }

        return new UserInfoUserDetails(user);
    }

}
