package com.etiqa.management.controller;

import com.etiqa.management.dto.BookRequest;
import com.etiqa.management.dto.BookResponse;
import com.etiqa.management.service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Product", description = "Product API")
@RestController
@AllArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private static Logger log = LogManager.getLogger(ProductController.class);

    @Autowired
    ProductService productService;

    @GetMapping("/findAllBooks")
    public ResponseEntity<List<BookResponse>> getAllBooks(){

        try{
            List<BookResponse> responseList = productService.getAllBooks();
            log.info("Return all books list");
            return new ResponseEntity<>(responseList, HttpStatus.OK);
        }
        catch (Exception ex){
            log.error(ex.toString());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/findBookById/{id}")
    public ResponseEntity<BookResponse> getBookById(@PathVariable("id") Long id){

        try{
            BookResponse response = productService.getBookById(id);
            log.info("Return all books by id " + id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception ex){
            log.error(ex.toString());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/createBook")
    public ResponseEntity<BookResponse> createBook(@RequestBody BookRequest request){

        try{
            BookResponse response = productService.saveBook(request);
            log.info("Book created id : {}", request.getId());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception ex){
            log.error(ex.toString());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/updateBook")
    public ResponseEntity<BookResponse> updateBook(@RequestBody BookRequest request){

        try{
            BookResponse response = productService.updateBook(request);
            log.info("Updated book id : {}", request.getId());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception ex){
            log.error(ex.toString());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/deleteBook")
    public ResponseEntity<BookResponse> deleteBook(@RequestBody BookRequest request){

        try{
            productService.deleteBook(request);
            log.info("Delete book {} is succesfull", request.getId());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception ex){
            log.error(ex.toString());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
