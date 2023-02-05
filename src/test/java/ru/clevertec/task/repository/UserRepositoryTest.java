package ru.clevertec.task.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.clevertec.task.entity.User;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
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