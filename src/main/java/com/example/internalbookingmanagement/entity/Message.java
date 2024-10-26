package com.example.internalbookingmanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Message extends AbstractEntity {
    private String owner;
    private String text;

    @ManyToOne
    @JoinColumn(name = "request_id")
    private Request request;
}
