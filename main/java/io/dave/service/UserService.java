package io.dave.service;

import java.util.List;

import io.dave.entity.User;

public interface UserService {
	List<User> getAllUsers();
/*
    Optional<User> getUserById(Long id);

    User createUser(User user);

    User updateUser(User user);

    void deleteUser(Long id);
    */
}
