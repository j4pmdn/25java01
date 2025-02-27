package fa.training.utils;

public class ValidationUtils {
	
	public static boolean isValidIsbn(String isbn) {
        return isbn.matches("\\d{1,5}-\\d{1,7}-\\d{1,7}-\\d{1,7}");
    }

}