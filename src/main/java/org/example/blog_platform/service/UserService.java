package org.example.blog_platform.service;

import lombok.RequiredArgsConstructor;
import org.example.blog_platform.model.User;
import org.example.blog_platform.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User save(User user) {
        return userRepository.save(user);
    }
}