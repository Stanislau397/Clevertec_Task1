package ru.clevertec.task.service;

import org.springframework.stereotype.Service;
import ru.clevertec.task.entity.User;

@Service
public interface UserService {

    User register(User user, String password);
}
