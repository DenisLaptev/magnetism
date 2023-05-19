package com.weblab.magnetism.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
@Table(name = "user_table")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    @Size(min = 2, max = 20, message = "Username should be from 2 to 20 chars")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "firstName")
    @Size(min = 2, max = 20, message = "First name should be from 2 to 20 chars")
    private String firstName;

    @Column(name = "lastName")
    @Size(min = 2, max = 20, message = "Last name should be from 2 to 20 chars")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Transient
    private List<String> authorities;
}
