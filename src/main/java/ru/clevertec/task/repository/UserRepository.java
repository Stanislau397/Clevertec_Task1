package ru.clevertec.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.clevertec.task.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> selectById(Long userId);
}
