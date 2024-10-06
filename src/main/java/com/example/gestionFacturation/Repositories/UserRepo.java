package com.example.gestionFacturation.Repositories;

import com.example.gestionFacturation.DTO.UserDTO;
import com.example.gestionFacturation.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    Optional<UserDTO> findByEmail(String email);
}
