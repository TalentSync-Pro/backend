package com.example.TalentSyncpro.Repository;

import com.example.TalentSyncpro.Models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin,String> {
    Optional<Admin> findByUsername(String username);
}
