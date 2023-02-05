package ru.clevertec.task.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.clevertec.task.entity.User;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
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

    void willSelectUserById() {
        Long userId = 1L;
        User user = new User();
        user.setUserName("Stanislau");
        user.setEmail("Some@gmail.com");
        user.setUSERID(userId);
        user.setPASSWORD("Ldasd12345");
        userRepository.save(user);
        Optional<User> expectedUser = userRepository.selectById(userId);
        assertThat(user).isEqualTo(expectedUser);
    }
}