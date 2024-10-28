package com.example.internalbookingmanagement.repo;

import com.example.internalbookingmanagement.entity.BaseUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepo extends JpaRepository<BaseUser, UUID> {

    Optional<BaseUser> findByUserName(String username);
}
