package com.example.TalentSyncpro.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="recruiters")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Recruiter extends BaseEntity{
    @Column(unique = true)
    @Email(message = "Enter Valid email address" )
    private String email;
    @Size(min = 10, message = "minimum 10 digits")
    private String phone;

}
