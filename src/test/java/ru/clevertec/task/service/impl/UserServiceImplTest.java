package ru.clevertec.task.service.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.clevertec.task.entity.User;
import ru.clevertec.task.repository.UserRepository;
import ru.clevertec.task.service.UserService;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

class UserServiceImplTest {

    @Mock
    private UserRepository UserRepository;
    private UserService underTest;
    private AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new UserServiceImpl(UserRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }



    @Test
    void willFindUserById() {

        Long userId = 1L;
        User user = new User();
        user.setUserName("Stanislau");
        user.setEmail("Some@gmail.com");
        user.setUSERID(userId);
        user.setPASSWORD("Ldasd12345");
        when(UserRepository.selectById(userId)).thenReturn(Optional.of(user));
        User expectedUser = underTest.findUserByUserId(userId);
        assertThat(user).isEqualTo(expectedUser);
    }

}