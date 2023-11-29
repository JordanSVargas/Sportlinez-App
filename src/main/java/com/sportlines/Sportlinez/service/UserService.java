package com.sportlines.Sportlinez.service;

import com.sportlines.Sportlinez.model.User;
import com.sportlines.Sportlinez.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> updateUser(Long userId, User user) {
        User originalUser = userRepository.findById(userId).orElse(null);
        if (originalUser != null) {
            originalUser.setFirstName(user.getFirstName());
            originalUser.setLastName(user.getLastName());
            // Set other fields as needed
            return Optional.of(userRepository.save(originalUser));
        }
        return Optional.empty();
    }

    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }
}
