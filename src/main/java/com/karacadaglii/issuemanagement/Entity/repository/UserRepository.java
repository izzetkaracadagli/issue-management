package com.karacadaglii.issuemanagement.Entity.repository;

import com.karacadaglii.issuemanagement.Entity.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
