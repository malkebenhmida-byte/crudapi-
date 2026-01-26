package com.example.crudapi.repository;

import com.example.crudapi.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, String>{
    
    
}
