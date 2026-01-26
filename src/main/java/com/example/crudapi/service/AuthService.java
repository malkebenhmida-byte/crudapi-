
package com.example.crudapi.service;

import com.example.crudapi.entity.User;
import com.example.crudapi.repository.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    
    @Autowired
    private UserRepository userRepository;

    public boolean login(String email, String password) {
        email = email.trim().toLowerCase();
        password = password.trim();
        
        Optional<User> userOpt = userRepository.findByEmail(email);

        if (userOpt.isPresent()) {
            User user = userOpt.get();
            return user.getPassword().equals(password); // simple (pas sécurisé)
        }

        return false;
    }
}
    

