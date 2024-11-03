package org.example.hw_31_30okt_SolidPrinzips;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Library {  //Поля: books, users
    public List<Book> books;
    public List<User> users;

    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public void removeBook(Book book) {
        this.books.remove(book);
    }

    public void registerUser(User user) {
        this.users.add(user);
    }

    public void findBookByIsbn(String isbn) {
        AtomicBoolean flag= new AtomicBoolean(false);
        this.books.stream().forEach((Book b) -> {
            if (b.isbn == isbn && b.availableCopies>=1) {
                flag.set(true);
            }
        });
        if (flag.get()) {
            System.out.println(" Книга с индексом " + isbn + " в наличии");
        } else {
            System.out.println(" Книга с индексом " + isbn + " на данный момент отсутсвует");
        }
    }
}