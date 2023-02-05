package ru.clevertec.task.service;

import org.springframework.stereotype.Service;
import ru.clevertec.task.entity.User;

@Service
public interface UserService {

    /**
     *
     * @param userFromRequest
     * @param password
     * @return
     */
    User register(User userFromRequest, String password);

    User findUserByUserId(Long userId);
}
