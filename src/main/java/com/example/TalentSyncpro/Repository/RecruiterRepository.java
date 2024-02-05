package com.example.TalentSyncpro.Repository;

import com.example.TalentSyncpro.Models.Admin;
import com.example.TalentSyncpro.Models.Recruiter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RecruiterRepository extends JpaRepository<Recruiter,String> {
    Optional<Recruiter> findByUsername(String username);
}
