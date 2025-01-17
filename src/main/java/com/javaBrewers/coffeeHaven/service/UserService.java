package com.javaBrewers.coffeeHaven.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.javaBrewers.coffeeHaven.model.Role;
import com.javaBrewers.coffeeHaven.model.User;
import com.javaBrewers.coffeeHaven.repository.RoleRepository;
import com.javaBrewers.coffeeHaven.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(User user, String roleName) {
        // Set the password and roles
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role selectedRole = roleRepository.findByName(roleName);
        Set<Role> roles = new HashSet<>();
        roles.add(selectedRole);
        user.setRoles(roles);

        return userRepository.save(user);
    }

    public User findByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        return user.orElse(null);
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}
