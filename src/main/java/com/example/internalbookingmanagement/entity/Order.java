package com.example.internalbookingmanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order extends AbstractEntity {
    private String status;
    private String orderNumber;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "employee_admin")
    private Employee employee;

    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private Double totalPrice;
    private UUID paymentId;


}
