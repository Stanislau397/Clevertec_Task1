package ru.clevertec.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.clevertec.task.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
