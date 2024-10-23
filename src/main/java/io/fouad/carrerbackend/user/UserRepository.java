package io.fouad.carrerbackend.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsUserByEmail(String email);
    boolean existsUserById(Integer id);
    Optional<User> findUserByEmail(String email);
}
