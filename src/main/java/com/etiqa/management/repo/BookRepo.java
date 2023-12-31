package com.etiqa.management.repo;

import com.etiqa.management.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BookRepo extends CrudRepository<Book, Long> {


}
