package com.example.internalbookingmanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Room extends AbstractEntity{
    private String roomName;
    private String amenities;
    private String board;
    private LocalDateTime freeCancellationUntil;
    private Double price;
    private Integer number;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

}
