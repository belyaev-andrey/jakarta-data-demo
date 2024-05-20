package org.example;


import jakarta.data.repository.By;
import jakarta.data.repository.DataRepository;
import jakarta.data.repository.Find;
import jakarta.data.repository.Repository;

import java.util.List;

@Repository
public interface BookRepository extends DataRepository<Book, String> {

    @Find
    List<Book> byTitle(String title);

    @Find
    Book findByIsbn(@By("isbn") String isbn);

    @Find
    List<Book> findAll();

}
