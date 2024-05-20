package org.example;

import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        var config = new Configuration();
        List.of(Book.class).forEach(config::addAnnotatedClass);
        try (var sessionFactory = config.buildSessionFactory()) {
            sessionFactory.inStatelessSession(session -> {
                        final BookRepository library = new BookRepository_(session);
                        library.findAll().forEach(System.out::println);
                        System.out.println(library.findByIsbn("9781932394153"));
                    }
            );
        }
    }
}