package com.example.TalentSyncpro.Repository;

import com.example.TalentSyncpro.Models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client,String> {
    Optional<Client> findByUsername(String username);
}
