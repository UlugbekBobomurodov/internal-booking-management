package com.example.internalbookingmanagement.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class BankDetails extends AbstractEntity {
    private String bankName;
    private String iban;
    private String swift;
    private String recipientName;
}
