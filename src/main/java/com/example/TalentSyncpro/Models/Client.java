package com.example.TalentSyncpro.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@Table(name="clients")
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@AllArgsConstructor
public class Client extends BaseEntity{
    @Column(unique = true)
    @Email(message = "Enter Valid email address" )
    private String email;
    @Size(min = 10, message = "minimum 10 digits")
    private String phone;

     //client info
    private String FirstName;
    private String LastName;
    private int mobile;
    private int exp;
    private String relevent_exp;
    private String qualification;
    private String SkillSet;
    private String Curr_JobTitle;
    private String Curr_WorkLoc;
    private String City;
    private int zipcode;
    File pdfFile = new File("example.pdf");
}
