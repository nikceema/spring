package com.etiqa.management.dto;

import lombok.Data;

@Data
public class BookResponse extends ProductResponse{

    private Long id;
    private String bookGenre;
    private String author;
    private Integer yearPublish;
}
