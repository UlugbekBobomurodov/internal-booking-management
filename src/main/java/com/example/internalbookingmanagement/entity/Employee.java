package com.example.internalbookingmanagement.entity;

import com.example.internalbookingmanagement.entity.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends AbstractEntity {

    private String username;
    private String password;
    private String email;
    private String phone;
    private String photo;

    @OneToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;
}
