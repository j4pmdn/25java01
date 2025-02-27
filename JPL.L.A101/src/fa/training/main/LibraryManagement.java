package fa.training.main;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import fa.training.entities.Book;
import fa.training.service.BookService;
import fa.training.service.BookServiceImpl;
import fa.training.service.MagazineImpl;
import fa.training.service.MagazineService;
import fa.training.utils.ValidationUtils;

public class LibraryManagement {
	
	private static BookService bookService = new BookServiceImpl();
    private static MagazineService magazineService = new MagazineImpl();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Add Book");
            System.out.println("2. Add Magazine");
            System.out.println("3. Search Book by ISBN");
            System.out.println("0. Exit");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addBook(scanner);
                    break;
                case 2:
                	addMagazine(scanner);
                    break;
                case 3:
                    searchBookByIsbn(scanner);
                    break;
            }
        } while (choice != 0);
    }

    private static void addBook(Scanner scanner) {
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        if (!ValidationUtils.isValidIsbn(isbn)) {
            System.out.println("Invalid ISBN format!");
            return;
        }
        System.out.print("Enter publisher: ");
        String publisher = scanner.nextLine();
        System.out.print("Enter publication year: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter publication place: ");
        String place = scanner.nextLine();
        bookService.addBook(new Book(year, publisher, new LocalDate(2024, 10, 12), isbn, place));
    }

    private static void searchBookByIsbn(Scanner scanner) {
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        List<Book> results = bookService.searchByIsbn(isbn);
        results.forEach(Book::display);
    }

}
