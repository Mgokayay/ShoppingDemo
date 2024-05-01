package com.invio.shopping.repository;

import com.invio.shopping.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    @Query("SELECT u FROM User u WHERE u.email = :email")
    Optional<User> findByEmail(String email);
}
