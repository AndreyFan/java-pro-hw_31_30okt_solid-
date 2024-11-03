package org.example.hw_31_30okt_SolidPrinzips;

public class LibraryManager implements issuanceBook{
    private Library library;

    public LibraryManager(Library library) {
        this.library = library;
    }


    public void addBook(Book book){ // библиотека получила новую книгу
        library.books.add(book);
    }


    public void  removeBook(Book book){ // списание книги если она уже в плохом состоянии
        library.books.remove(book);
    }
    public void registerUser(User user){ // регистрация нового пользователя
        library.users.add(user);
    }

}
