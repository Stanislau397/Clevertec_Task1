package ru.clevertec.task.service.impl;

import ru.clevertec.task.entity.User;

import ru.clevertec.task.exception.InvalidInputException;
import ru.clevertec.task.repository.UserRepository;
import ru.clevertec.task.service.UserService;

import static ru.clevertec.task.validation.UserValidator.isEmailValid;
import static ru.clevertec.task.validation.UserValidator.isPasswordValid;
import static ru.clevertec.task.validation.UserValidator.isUsernameValid;


public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Override
    public User register(User userFromRequest, String password) {
        User savedUser = new User();
        if (isUsernameValid(userFromRequest.getUserName())
                && isEmailValid(userFromRequest.getEmail())
                && isPasswordValid(userFromRequest.getPASSWORD())) {
            userFromRequest.setPASSWORD(password);
            savedUser = userRepository.save(userFromRequest);
        }
        return savedUser;
    }

    @Override
    public User findUserByUserId(Long userId) {
        return userRepository.selectById(userId)
                .orElseThrow(() -> new InvalidInputException(String.format("User with id %s not found", userId)));
    }
}
