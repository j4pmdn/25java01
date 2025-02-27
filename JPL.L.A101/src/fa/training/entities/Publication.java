package fa.training.entities;

import java.time.LocalDate;

public abstract class Publication {

	protected int publicationYear;
	protected String publisher;
	protected LocalDate publicationDate;

	public Publication(int publicationYear, String publisher, LocalDate publicationDate) {
		this.publicationYear = publicationYear;
		this.publisher = publisher;
		this.publicationDate = publicationDate;
	}

	public abstract void display();

	public int getPublicationYear() {
		return publicationYear;
	}

	public String getPublisher() {
		return publisher;
	}
}
