package com.example.internalbookingmanagement.entity;

import jakarta.persistence.Entity;
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
public class Hotel extends AbstractEntity {
    private String orderNumber;
    private UUID externalId;
    private String country;
    private String city;
}
