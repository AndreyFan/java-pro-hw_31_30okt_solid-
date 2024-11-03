package org.example.hw_31_30okt_SolidPrinzips;

public interface issuanceBook {  // решил методы выдачи и возврата сделать отдельным интерфейсом,
    // чтобы они были доступны и через менеджера и клиенту (если он берет и возвращает книгу через терминал
    // как это происходит в местной библиотеке
    public default void borrowBook(Library library, String isbn, User user){ // выдача книги клиенту
        library.books.stream().forEach((Book b)->{ if (b.isbn==isbn) {
            if (b.availableCopies >= 1){
                b.availableCopies -=1;// списали книгу из библиотеки для случая если она не в одном экземпляре
                user.borrowedBooks.add(b); // записали её на конкретного клиента
                System.out.println(" Книга с индексом "+isbn+ " выдана пользователю " + user.name);
            } else if (b.availableCopies == 0)
                System.out.println(" Все экземпляры этой книги с индексом " + isbn+ " выданы");
        }});
    }

    public default void returnBook(Library library,String isbn, User user){ // возврат книги клиентом в библиотеку
        library.books.stream().forEach((Book b)->{ if (b.isbn==isbn) {
            user.borrowedBooks.remove(b); // списали книгу с конкретного клиента
          // !!! МЕТОД возврата книги нужно усложнить
            b.availableCopies += 1 ; // поставили книгу на учет библиотеки
            System.out.println(" Книга с индексом "+isbn+ " возвращена пользователем  " + user.name + " в библиотеку.");
        }});
    }

}
