package com.example.gestionFacturation.Services.Interfaces;

import com.example.gestionFacturation.DTO.UserDTO;

import java.util.Optional;

public interface IUserService {
    Optional<UserDTO> GetAllUsers(String email);

    Optional<UserDTO> GetUserByEmail(String email);

    Optional<UserDTO> GetUserById(int id);

    Optional<UserDTO> UpdateUser(UserDTO userDTO);

    Optional<UserDTO> DeleteUser(int id);

    Optional<UserDTO> CreateUser(UserDTO userDTO);
}
