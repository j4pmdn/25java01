package fa.training.service;

import java.util.List;

import fa.training.entities.Book;

public interface BookService {
	
	void addBook(Book book);
    List<Book> searchByIsbn(String isbn);
    List<Book> searchByAuthor(String author);
    List<Book> searchByPublisher(String publisher);

}
