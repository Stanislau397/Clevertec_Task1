package ru.clevertec.task.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.clevertec.task.entity.User;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void willSaveUser() {
        User user = new User();
        user.setUserName("Stanislau");
        user.setUSERID(1L);
        user.setPASSWORD("Password");
        user.setEmail("Email@gmail.com");
        User expectedUser = userRepository.save(user);
        assertThat(user).isEqualTo(expectedUser);
    }

}