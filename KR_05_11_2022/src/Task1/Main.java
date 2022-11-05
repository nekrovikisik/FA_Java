package Task1;

import Task1.Book;

public class Main {
    public static void main(String[] args) {
        var readers = new Reader[] {new Reader("Иванов И. И.", "ИТиАБД", "01.01.2002", 12345),
                new Reader("Петров В. В", "ИТиАБД", "05.11.2002", 67890) };
        var reader1 = readers[0];
        var reader2 = readers[1];

        var book1 = new Book("Приключения");
        var book2 = new Book("Словарь");
        var books = new Book[] {book1, book2};

        reader1.takeBook(1);
        reader1.takeBook(new String[] {"Энциклопеция","Роман"});
        reader1.takeBook(books);

        reader2.returnBook(2);
        reader2.returnBook(new String[] {"Энциклопеция","Роман"});
        reader2.returnBook(books);

    }
}
