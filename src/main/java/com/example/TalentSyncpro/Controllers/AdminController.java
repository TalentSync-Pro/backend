package com.example.TalentSyncpro.Controllers;

import com.example.TalentSyncpro.Config.UserDetailsServiceImpl;
import com.example.TalentSyncpro.Config.UserInfoUserDetails;
import com.example.TalentSyncpro.DTOs.RequestDto.AdminRequestDto;
import com.example.TalentSyncpro.DTOs.RequestDto.AuthRequest;
import com.example.TalentSyncpro.DTOs.ResponseDto.AuthResponse;
import com.example.TalentSyncpro.Models.Admin;
import com.example.TalentSyncpro.Service.AdminService;
import com.example.TalentSyncpro.Service.JWTService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {


    @Autowired
    private AdminService adminService;

    @GetMapping("/welcome")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<String> greetings(){

        return ResponseEntity.ok("I am Admin and i am authenticated");
    }

    @PostMapping("/addAdmin")
    @PreAuthorize("hasAuthority('ROLE_SUPERADMIN')")
    public ResponseEntity<String> createAdmin(@Valid @RequestBody AdminRequestDto adminDto, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            // Handle validation errors
            return ResponseEntity.badRequest().body("Validation error: " + bindingResult.getAllErrors());
        }

        String response = adminService.createAdmin(adminDto);

        return ResponseEntity.ok().body(response);
    }

}
