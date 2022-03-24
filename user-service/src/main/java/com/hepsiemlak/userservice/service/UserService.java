package com.hepsiemlak.userservice.service;

import com.hepsiemlak.userservice.exception.BadRequestException;
import com.hepsiemlak.userservice.exception.NotFoundException;
import com.hepsiemlak.userservice.model.User;
import com.hepsiemlak.userservice.model.event.UserCreatedEvent;
import com.hepsiemlak.userservice.model.event.UserDeletedEvent;
import com.hepsiemlak.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final MqNotifyService mqNotifyService;

    public void save(User user) {
        if(userRepository.existsByUsername(user.getUsername())) throw new BadRequestException("User Already Exist");
        validateUser(user);
        User savedUser = userRepository.save(user);
        mqNotifyService.notifyUser(savedUser, new UserCreatedEvent());
    }

    public User get(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) throw new NotFoundException("User not found");
        return user.get();
    }

    public void update(User user) {
        if(!userRepository.existsById(user.getId())) throw new NotFoundException("User not found");
        if(userRepository.existsByUsername(user.getUsername())) throw new BadRequestException("User already exist");
        validateUser(user);
        userRepository.save(user);
    }

    public void delete(Long id) {
        if (!userRepository.existsById(id)) throw new NotFoundException("User not found");
        userRepository.deleteById(id);
        User user = new User();
        user.setId(id);
        mqNotifyService.notifyUser(user, new UserDeletedEvent());
    }

    public User findByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isEmpty()) throw new NotFoundException("User not found");
        return user.get();
    }


    private void validateUser(User user) {
        if (user.getUsername() == null || user.getUsername().isEmpty()) {
            throw new BadRequestException("Username is required");
        }
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            throw new BadRequestException("Password is required");
        }
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new BadRequestException("Email is required");
        }
        if (user.getFirstName() == null || user.getFirstName().isEmpty()) {
            throw new BadRequestException("First name is required");
        }
        if (user.getLastName() == null || user.getLastName().isEmpty()) {
            throw new BadRequestException("Last name is required");
        }
        if (user.getUserType() == null) {
            throw new BadRequestException("User type is required");
        }
    }
}
