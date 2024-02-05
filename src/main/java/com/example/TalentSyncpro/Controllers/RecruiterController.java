package com.example.TalentSyncpro.Controllers;

import com.example.TalentSyncpro.DTOs.RequestDto.RecruiterRequestDto;
import com.example.TalentSyncpro.Service.RecruiterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recruiter")
public class RecruiterController {

    @Autowired
    private RecruiterService recruiterService;

//    @GetMapping("/welcome")
//    @PreAuthorize("hasAuthority('ROLE_RECRUITER') or hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_SUPERADMIN')")
//    public ResponseEntity<String> greetings(){
//
//        return ResponseEntity.ok("I am Recruiter and i am authenticated");
//    }

    @PostMapping("/addRecruiter")
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_SUPERADMIN')")
    public ResponseEntity<String> addRecruiter(@Valid @RequestBody RecruiterRequestDto recruiterRequestDto, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            // Handle validation errors
            return ResponseEntity.badRequest().body("Validation error: " + bindingResult.getAllErrors());
        }

        String response = recruiterService.addRecruiter(recruiterRequestDto);
        return ResponseEntity.ok().body(response);
    }
}
