package fa.training.service;

import fa.training.entities.Book;
import static fa.training.utils.ValidationUtils.*;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BookService{
	
	private List<Book> books = new ArrayList<>();

	@Override
	public void addBook(Book book) {
		if(isValidIsbn(book.getIsbn())) {
			books.add(book);
			System.out.println("Book added successfully.");
		}else {
			System.out.println("Invalid ISBN.");
		}
	}
	
	@Override
    public List<Book> searchByIsbn(String isbn) {
        return books.stream().filter(b -> b.getIsbn().equals(isbn)).toList();
    }

    @Override
    public List<Book> searchByAuthor(String author) {
        return books.stream().filter(b -> b.getAuthors().contains(author)).toList();
    }

    @Override
    public List<Book> searchByPublisher(String publisher) {
        return books.stream().filter(b -> b.getPublisher().equalsIgnoreCase(publisher)).toList();
    }

}
