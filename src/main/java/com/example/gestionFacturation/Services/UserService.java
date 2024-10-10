package com.example.gestionFacturation.Services;

import com.example.gestionFacturation.DTO.UserDTO;
import com.example.gestionFacturation.Services.Interfaces.IUserService;

import java.util.Optional;

public class UserService implements IUserService {
    @Override
    public Optional<UserDTO> GetAllUsers(String email) {
        return Optional.empty();
    }

    @Override
    public Optional<UserDTO> GetUserByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public Optional<UserDTO> GetUserById(int id) {
        return Optional.empty();
    }

    @Override
    public Optional<UserDTO> UpdateUser(UserDTO userDTO) {
        return Optional.empty();
    }

    @Override
    public Optional<UserDTO> DeleteUser(int id) {
        return Optional.empty();
    }

    @Override
    public Optional<UserDTO> CreateUser(UserDTO userDTO) {
        return Optional.empty();
    }
}
