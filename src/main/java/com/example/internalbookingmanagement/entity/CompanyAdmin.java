package com.example.internalbookingmanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CompanyAdmin extends BaseUser {

    private String phone;
    private String photo;
    @OneToOne
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile profile;
    @OneToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
}
