package app_1.jwtApp.repository;

import app_1.jwtApp.entities.User1;
import app_1.jwtApp.payload.LoginDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface User1Repository extends JpaRepository<User1, Long> {
    Optional<User1> findByUsername(String user);
    Optional<User1> findByEmailId(String user);

    Optional<User1> findByUsername(LoginDto dto);
}