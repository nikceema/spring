package com.etiqa.management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.util.UUID;

@Data
@MappedSuperclass
public class Person {

    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String homeAddress;
    @Column
    private String mobileNo;
    @Column
    private String privateEmail;
}
