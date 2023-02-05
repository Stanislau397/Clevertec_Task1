package ru.clevertec.task.service.impl;

import ru.clevertec.task.entity.User;
import ru.clevertec.task.exception.InvalidInputException;
import ru.clevertec.task.repository.UserRepository;
import ru.clevertec.task.service.UserService;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findUserByUserId(Long userId) {
        return userRepository.selectById(userId)
                .orElseThrow(() -> new InvalidInputException(String.format("User with id %s not found", userId)));
    }
}
