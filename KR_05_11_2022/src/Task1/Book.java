package Task1;

public class Book {
    public String name;

    public Book(String name) {
        this.name = name;
    }

    public Book(Book book) {
        this.name = name;
    }

    @Override
    public String toString(){
        return this.name;
    }

}
