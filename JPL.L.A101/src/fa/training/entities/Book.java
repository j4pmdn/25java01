package fa.training.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Book extends Publication {

	private String isbn;
    private Set<String> authors;
    private String publicationPlace;

    public Book(int publicationYear, String publisher, LocalDate publicationDate, String isbn, String publicationPlace) {
        super(publicationYear, publisher, publicationDate);
        this.isbn = isbn;
        this.publicationPlace = publicationPlace;
        this.authors = new HashSet<>();
    }

    public void addAuthor(String author) {
        if (authors.contains(author)) {
            System.out.println("Author existed");
        } else {
            authors.add(author);
            System.out.println("Add successfully");
        }
    }

    public String getIsbn() {
        return isbn;
    }

    public Set<String> getAuthors() {
        return authors;
    }

    @Override
    public void display() {
        System.out.println("Book: ISBN=" + isbn + ", Publisher=" + publisher + ", Year=" + publicationYear + ", Authors=" + authors + ", Place=" + publicationPlace);
    }

}
