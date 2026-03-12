package org.example.identity.repository;

import org.example.identity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    User findUserByPhone(String phone);

    User findUserByEmail(String email);
}

