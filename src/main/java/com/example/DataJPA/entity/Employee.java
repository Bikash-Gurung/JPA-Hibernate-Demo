package com.example.DataJPA.entity;

import com.example.DataJPA.enums.Gender;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private String firsName;

    @Column
    @NotNull
    private String lastName;

    @Column
    @NotNull
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column
    @NotNull
    private int age;

    @Column
    private String address;
}

