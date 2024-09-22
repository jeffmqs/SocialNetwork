package com.jeffdev.jshare.entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "users", schema= "JSHARE")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator= "users_sq")
    @SequenceGenerator(schema= "JSHARE", name = "users_sq", sequenceName= "users_sq", initialValue= 1, allocationSize=1)
    private Long id;

    private String name;

    private String email;

    @Column(unique=true)
    private String username;

    private String password;

    private String bio;

    private boolean active;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updateAt;


    
}
