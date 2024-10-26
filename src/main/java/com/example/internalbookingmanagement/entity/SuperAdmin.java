package com.example.internalbookingmanagement.entity;

import com.example.internalbookingmanagement.entity.enums.UserStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class SuperAdmin extends AbstractEntity{


    @Enumerated(EnumType.STRING)
    private UserStatus status;
    private String username;
    private String password;
    private String email;


}
