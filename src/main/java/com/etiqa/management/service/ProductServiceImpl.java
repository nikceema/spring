package com.etiqa.management.service;

import com.etiqa.management.dto.BookRequest;
import com.etiqa.management.dto.BookResponse;
import com.etiqa.management.dto.CustomerRequest;
import com.etiqa.management.dto.CustomerResponse;
import com.etiqa.management.entity.Book;
import com.etiqa.management.entity.Customer;
import com.etiqa.management.repo.BookRepo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService{

    private static final Logger log = LogManager.getLogger(ProductServiceImpl.class);
    private ObjectMapper objectMapper;

    @Autowired
    private BookRepo bookRepo;

    @Override
    public List<BookResponse> getAllBooks() {

        List<Book> bookList = new ArrayList<>();
        Iterable<Book> bookIterable = bookRepo.findAll();

        if(bookIterable != null){
            bookIterable.forEach(bookList::add);
        }

        List<BookResponse> bookResponseList = objectMapper.convertValue(bookList,
                new TypeReference<List<BookResponse>>() {});

        log.info("All books list : " + bookList.size());

        return bookResponseList;
    }

    @Override
    public BookResponse getBookById(Long id) throws Exception {
        if(id == null){
            log.error("getBookById - id is null.");
            throw new Exception("getBookById - id is null");
        }

        Optional<Book> book = bookRepo.findById(id);
        BookResponse bookResponse = objectMapper.convertValue(book.get(), BookResponse.class);

        return  bookResponse;
    }

    @Override
    public BookResponse saveBook(BookRequest request) throws Exception {

        if(request == null){
            log.error("saveCustomer - Request body is null");
            throw new Exception("saveCustomer - Request body is null");
        }

        Book book = objectMapper.convertValue(request, Book.class);
        bookRepo.save(book);

        log.info("Successfully save/create book : " + request);

        BookResponse response = objectMapper.convertValue(book, BookResponse.class);

        return response;
    }

    @Override
    public BookResponse updateBook(BookRequest request) throws Exception {

        if(request == null){
            log.error("updateBook - Request body is null");
            throw new Exception("updateBook - Request body is null");
        }

        if(request != null && request.getId() == null){
            log.error("updateBook - Request id is null");
            throw new Exception("updateBook - Request id is null");
        }

        Optional<Book> bookOri = bookRepo.findById(request.getId());
        if(bookOri == null || bookOri.isEmpty()){
            throw new Exception("updateBook - Cannot find book by id : " + request.getId());
        }

        Book book = objectMapper.convertValue(request, Book.class);
        if(book.getBookGenre() == null){
            book.setBookGenre(bookOri.get().getBookGenre());
        }
        if(book.getAuthor() == null){
            book.setAuthor(bookOri.get().getAuthor());
        }
        if(book.getYearPublish() == null){
            book.setYearPublish(bookOri.get().getYearPublish());
        }
        if(book.getPrice() == null){
            book.setPrice(bookOri.get().getPrice());
        }
        if(book.getCategory() == null){
            book.setCategory(bookOri.get().getCategory());
        }
        if(book.getQuantity() == null){
            book.setQuantity(bookOri.get().getQuantity());
        }
        if(book.getTitleName() == null){
            book.setTitleName(bookOri.get().getTitleName());
        }
        bookRepo.save(book);

        log.info("Successfully update Book : " + request.toString());

        BookResponse response = objectMapper.convertValue(book, BookResponse.class);

        return response;
    }

    @Override
    public void deleteBook(BookRequest request) throws Exception {

        if(request == null){
            log.error("deleteBook - Request body is null");
            throw new Exception("deleteBook - Request body is null");
        }

        if(request != null && request.getId() == null){
            log.error("deleteBook - Request id is null");
            throw new Exception("deleteBook - Request id is null");
        }

        Optional<Book> bookOri = bookRepo.findById(request.getId());

        if(bookOri == null || bookOri.isEmpty()){
            throw new Exception("deleteBook - Cannot find book by id : " + request.getId());
        }

        bookRepo.deleteById(request.getId());
        log.info("deleteCustomer - successfully delete customer {}", bookOri);

    }
}
