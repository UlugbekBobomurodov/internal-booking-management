package com.example.internalbookingmanagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Profile extends AbstractEntity {

    private String name;
    private String surname;
    private String nationality;
    @Column(name = "date_of_birth")
    private LocalDate birthDate;
}
