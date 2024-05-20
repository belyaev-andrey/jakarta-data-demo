package org.example;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Book {
    @Id
    String isbn;

    @NaturalId
    String title;

    @NaturalId(mutable = true)
    LocalDate publicationDate;

    String text;

    @Basic(optional = false)
    int pages;

    BigDecimal price;
    BigInteger quantitySold;

    public Book(String isbn, String title, String text) {
        this.isbn = isbn;
        this.title = title;
        this.text = text;
    }

    protected Book() {}

    @Override
    public String toString() {
        return "%s : %s".formatted(getIsbn(), getTitle());
    }
}

