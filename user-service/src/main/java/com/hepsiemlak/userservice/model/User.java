package com.hepsiemlak.userservice.model;

import com.hepsiemlak.userservice.model.enums.UserType;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private UserType userType;
    private String address;
    private String city;
    private String country;

}
