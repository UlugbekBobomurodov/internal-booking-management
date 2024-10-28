package com.example.internalbookingmanagement.entity;

import com.example.internalbookingmanagement.entity.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class SuperAdmin extends AbstractEntity{

    @Enumerated(EnumType.STRING)
    private Role status;
    private String username;
    private String password;
    private String email;


}
