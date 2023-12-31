package com.etiqa.management.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

@Data
@Entity
@DynamicUpdate
@Table(name="book")
public class Book extends Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String bookGenre;
    @Column
    private String author;
    @Column
    private Integer yearPublish;
}
