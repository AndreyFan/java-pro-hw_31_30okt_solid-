package org.example.hw_31_30okt_SolidPrinzips;

public class MainLibrary {
    // Задача: Создание системы управления библиотекой с использованием принципов SOLID
    //Описание задачи:
    //Вы работаете в компании, занимающейся разработкой программного обеспечения для управления библиотеками.
    //Ваша задача - создать систему классов, которая будет соответствовать принципам SOLID
    //и позволит эффективно управлять библиотекой. Основные функции системы включают добавление новых книг,
    //учет взятых и возвращенных книг.
    //
    //Описание классов:
    //Book:
    //Поля: title, author, isbn, availableCopies
    //
    //User:
    //Поля: name, userId, borrowedBooks
    //Методы:  borrowBook(Book book), returnBook(Book book) - методы для добавления и удаления книг из borrowedBooks
    //
    //Library:
    //Поля: books, users
    //Методы: addBook(Book book), removeBook(Book book), registerUser(User user), findBookByIsbn(String isbn)
    //
    //LibraryManager:
    //Поля: library
    //Методы: borrowBook(String isbn, User user), returnBook(String isbn, User user),
    //addBook(Book book), removeBook(Book book), registerUser(User user)

    public static void main(String[] args) {  // имитируем работу библиотеки и проверяем методы
        Book book1 = new Book("Собрание сочинений", "Владимир Набоков", "5-89091-051-5", 2);
        Book book2 = new Book("Эзоп.Басни и истории", "Гаспаров М", "978-5-699-38030-5", 1);
        Book book3 = new Book("Вечный человек", "Гильберт Кит Честертон", "978-5-389-24518-1", 3);
        Book book4 = new Book("Книга по чтению", "Гудзик И.Ф.", "996-04-0252-X", 1);
        Book book5 = new Book("Louisa", "Frauke Scheunemann", "978-3-7891-0999-7", 1);

        Library library = new Library();  // создаём библиотеку
        library.addBook(book1); // добавим все наши книги в библиотеку
        library.addBook(book2); // добавим все наши книги в библиотеку
        library.addBook(book3); // добавим все наши книги в библиотеку
        library.addBook(book4); // добавим все наши книги в библиотеку
        library.addBook(book5); // добавим все наши книги в библиотеку

        System.out.println(" просмотрим книги нашей библиотеки");
        for (Book item : library.books) {
            System.out.println(item);
        }
        System.out.println();

        System.out.println(" проверим работу поиска: ");
        library.findBookByIsbn("996-04-0252-X");
        library.findBookByIsbn("996-04-0252-2");
        System.out.println();


        User user1 = new User("Peter", "1", null); // создадим пару пользователей
        User user2 = new User("Olga", "2", null);
        library.registerUser(user1);  // зарегистрируем пользователей в библиотеке
        library.registerUser(user2);


        System.out.println(" просмотрим список пользователей нашей библиотеки: ");
        for (User item : library.users) {
            System.out.println(item);
        }
        System.out.println();

        LibraryManager libraryManager = new LibraryManager(library); // пригласили менеджера на работу и передали ему нашу библиотеку
        libraryManager.borrowBook(library, "996-04-0252-X", user1); // выдали "Книга по чтению" Юзеру 1
        libraryManager.borrowBook(library, "996-04-0252-X", user2); // пытаемся выдать "Книга по чтению" Юзеру2
        System.out.println();

        System.out.println("  Снова просмотрим список пользователей нашей библиотеки, чтобы увидеть изменения у юзера 1: ");
        for (User item : library.users) {
            System.out.println(item);
        }
        System.out.println();

        user1.returnBook(library, "996-04-0252-X", user1); // возврат "Книга по чтению" Юзером 1
        System.out.println();

        System.out.println("  Снова просмотрим список пользователей нашей библиотеки, чтобы увидеть изменения у юзера 1: ");
        for (User item : library.users) {
            System.out.println(item);
        }
        System.out.println();

    }
}
