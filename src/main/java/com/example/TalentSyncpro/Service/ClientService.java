package com.example.TalentSyncpro.Service;

import com.example.TalentSyncpro.DTOs.RequestDto.ClientRequestDto;
import com.example.TalentSyncpro.Models.Client;
import com.example.TalentSyncpro.Repository.ClientRepository;
import com.example.TalentSyncpro.Transformers.ClientTransformer;
import com.example.TalentSyncpro.Transformers.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String addClient(ClientRequestDto clientRequestDto) {

        Client client = ClientTransformer.convertDtoToEntity(clientRequestDto);

        client.setUuid(UserTransformer.generateRandomUuid());
        client.setPassword(passwordEncoder.encode((client.getPassword())));

        clientRepository.save(client);
        return "Client created successfully";
    }

}
