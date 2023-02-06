package com.wy.SpikeShopping.service;

import com.wy.SpikeShopping.model.User;
import com.wy.SpikeShopping.repository.UserRepository;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    PasswordEncoder bCryptPasswordEncoder;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(String.valueOf(id))
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
    }

    public User createUser(User user) {
        user.setEncryptedPassword(user.getEncryptedPassword());
        return userRepository.save(user);
    }

    public User updateUser(Long id, User user) {
        User existingUser = getUserById(id);
        existingUser.setName(user.getName());
        existingUser.setAge(user.getAge());
        existingUser.setGender(existingUser.getGender());
        existingUser.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getEncryptedPassword()));
        return userRepository.save(existingUser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(String.valueOf(id));
    }

    public User authenticate(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Username or password is missing");
        }
        User user = userRepository.findByName(username);
        if (user == null || !BCrypt.checkpw(username, user.getEncryptedPassword())) {
            throw new IllegalArgumentException("Invalid username or password");
        }
        return user;
    }
}
