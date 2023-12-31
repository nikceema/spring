package com.etiqa.management.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

@Data
@Entity
@DynamicUpdate
@Table(name = "customer")
public class Customer extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String officeEmail;
    @Column
    private String contactAddress;
    @Column
    private String officeNo;
    @Column
    private String customerType;
    @Column
    private String relationship;
    @OneToMany(targetEntity = Customer.class)
    private List<Customer> familyMembers;

}
