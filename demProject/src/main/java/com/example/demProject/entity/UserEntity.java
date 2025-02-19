package com.example.demProject.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "DataOfUser")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    private String email;
    private String phone;
    private String firstname;
    private String surname;

}