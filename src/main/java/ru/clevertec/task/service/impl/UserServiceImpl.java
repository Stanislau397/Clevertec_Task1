package ru.clevertec.task.service.impl;

import ru.clevertec.task.entity.User;
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
    public User registerUser(User user, String password) {
        User savedUser = new User();
        if (isUsernameValid(user.getUserName())
                && isEmailValid(user.getEmail())
                && isPasswordValid(user.getPASSWORD())) {
            user.setPASSWORD(password);
            savedUser = userRepository.save(user);
        }
        return savedUser;
    }
}
