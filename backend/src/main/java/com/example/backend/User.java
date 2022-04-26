package com.example.backend;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="user_details")
@NoArgsConstructor
@AllArgsConstructor


public class User {
    @Id
    @GeneratedValue
    private int id;

    @Column(name="studentName") private String studentName;

    @Column(name="studentRollNo") private String studentRollNo;

    @Column(name="year") private String  year;

    @Column(name="branch") private String  branch;

    @Column(name="section") private String section;

    @Column(name = "password")  private String password;
    
}
