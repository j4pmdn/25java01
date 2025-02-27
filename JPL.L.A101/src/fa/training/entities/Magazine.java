package fa.training.entities;

import java.time.LocalDate;

public class Magazine extends Publication {

	private String author;
    private int volume;
    private int edition;

    public Magazine(int publicationYear, String publisher, LocalDate publicationDate, String author, int volume, int edition) {
        super(publicationYear, publisher, publicationDate);
        this.author = author;
        this.volume = volume;
        this.edition = edition;
    }
    
    public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getEdition() {
		return edition;
	}

	public void setEdition(int edition) {
		this.edition = edition;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public int getVolume() {
        return volume;
    }

    @Override
    public void display() {
        System.out.println("Magazine: Author=" + author + ", Publisher=" + publisher + ", Year=" + publicationYear + ", Volume=" + volume + ", Edition=" + edition);
    }
	
}
