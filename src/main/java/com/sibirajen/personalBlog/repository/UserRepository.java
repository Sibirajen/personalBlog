package com.sibirajen.personalBlog.repository;

import com.sibirajen.personalBlog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmailId(String emailId);

    Optional<User> findByEmailId(String emailId);
}
