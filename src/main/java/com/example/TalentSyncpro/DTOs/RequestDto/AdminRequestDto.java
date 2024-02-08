package com.example.TalentSyncpro.DTOs.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminRequestDto {

    private String username;
    private String password;
    private String email;
    private String phone;
    private String role;

}
