package org.example.hw_31_30okt_SolidPrinzips;

import java.util.ArrayList;
import java.util.List;

public class User implements issuanceBook{
    public String name;
    public String userId;
    public List<Book> borrowedBooks ;

    public User(String name, String userId, List<Book> borrowedBooks) {
        this.name = name;
        this.userId = userId;
        this.borrowedBooks = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", userId='" + userId + '\'' +
                ", borrowedBooks=" + borrowedBooks +
                '}';
    }
}
