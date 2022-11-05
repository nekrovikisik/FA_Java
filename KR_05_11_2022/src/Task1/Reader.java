package Task1;

import Task1.Book;

public class Reader {
    public String name;
    public int reader_number; // номер читательского билета
    public String faculty;
    public String birthday;
    public int telephone;

    public Reader(String name, String faculty, String birthday, int telephone) {
        this.name = name;
        this.birthday = birthday;
        this.reader_number = (int) (Math.random() * 100000);
        this.telephone = telephone;
        this.faculty = faculty;
    }

    public void takeBook(int n) {
        System.out.println("\n" + name + " взял " + n + " книг");
    }

    public void takeBook(String[] books) {
        System.out.print("\n" + name + " взял книги: ");
        for (String b : books) {
            System.out.print(b + ", ");
        }
    }

    public void takeBook(Book[] books) {
        System.out.print("\n" + name + " взял книги: ");
        for (Book b : books) {
            System.out.print(b + ", ");
        }
    }

    public void returnBook(int n) {
        System.out.println("\n" + name + " вернул " + n + " книг");
    }

    public void returnBook(String[] books) {
        System.out.print("\n" + name + " вернул книги: ");
        for (String b : books) {
            System.out.print(b + ", ");
        }
    }

    public void returnBook(Book[] books) {
        System.out.print("\n" + name + " вернул книги: ");
        for (Book b : books) {
            System.out.print(b + ", ");
        }
    }
}
