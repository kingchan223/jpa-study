package hellojpa.advancedMapping.entity;

import javax.persistence.Entity;

//@Entity
public class Book extends Item{
    private String author;
    private String isbn;

    public Book() {
    }

    public Book(String author, String isbn) {
        this.author = author;
        this.isbn = isbn;
    }
}
