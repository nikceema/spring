package com.etiqa.management.dto;

import lombok.Data;

@Data
public class BookRequest extends ProductRequest{

    private Long id;
    private String bookGenre;
    private String author;
    private Integer yearPublish;
}
