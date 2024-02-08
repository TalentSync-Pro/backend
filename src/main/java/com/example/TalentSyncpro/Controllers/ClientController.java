package com.example.TalentSyncpro.Controllers;

import com.example.TalentSyncpro.DTOs.RequestDto.ClientRequestDto;
import com.example.TalentSyncpro.DTOs.RequestDto.RecruiterRequestDto;
import com.example.TalentSyncpro.Service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

//    @GetMapping("/welcome")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_CLIENT') or hasAuthority('ROLE_SUPERADMIN')")
//    public ResponseEntity<String> greetings(){
//
//        return ResponseEntity.ok("I am Client and i am authenticated");
//    }

    @PostMapping("/addClient")
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_SUPERADMIN')")
    public ResponseEntity<String> addClient(@Valid  @RequestBody ClientRequestDto clientRequestDto, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            // Handle validation errors
            return ResponseEntity.badRequest().body("Validation error: " + bindingResult.getAllErrors());
        }

        String response = clientService.addClient(clientRequestDto);
        return ResponseEntity.ok().body(response);
    }
}
