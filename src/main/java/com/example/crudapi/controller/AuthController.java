
package com.example.crudapi.controller;
import com.example.crudapi.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200") // Angular
public class AuthController {
      @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        
        System.out.println("Email reçu : " + request.getEmail());
        System.out.println("Password reçu : " + request.getPassword());
        
        boolean ok = authService.login(request.getEmail(), request.getPassword());

        if (ok) {
            return ResponseEntity.ok().body("LOGIN_SUCCESS");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("LOGIN_FAILED");
        }
    }
}
