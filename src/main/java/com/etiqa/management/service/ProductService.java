package com.etiqa.management.service;

import com.etiqa.management.dto.BookRequest;
import com.etiqa.management.dto.BookResponse;
import com.etiqa.management.dto.CustomerRequest;
import com.etiqa.management.dto.CustomerResponse;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    List<BookResponse> getAllBooks();
    BookResponse getBookById(Long id) throws Exception;
    BookResponse saveBook(BookRequest request) throws Exception;
    BookResponse updateBook(BookRequest request) throws Exception;
    void deleteBook(BookRequest request) throws Exception;
}
