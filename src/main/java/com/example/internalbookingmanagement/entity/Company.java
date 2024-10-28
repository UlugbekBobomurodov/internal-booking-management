package com.example.internalbookingmanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "company")
public class Company extends AbstractEntity {

    private String status;
    private String name;
    private String industry;
    private Integer companySize;
    private String registrationCode;
    private String vatCode;
    private String registrationAddress;
    private String country;
    private String logo;

    @OneToOne
    @JoinColumn(name = "bank_details_id")
    private BankDetails bankDetailsId;


}
