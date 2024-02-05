package com.example.TalentSyncpro.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;


@MappedSuperclass
@Data
public class BaseEntity {

    @Id
    private String uuid;
    @Column(unique = true,nullable = false)
    @NotBlank(message = "Name cannot be blank")
    private String username;
    private String password;
    private String role;
}
