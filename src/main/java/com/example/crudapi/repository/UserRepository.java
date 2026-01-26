
package com.example.crudapi.repository;
import com.example.crudapi.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String>{
    Optional<User> findByEmail(String email);
}
