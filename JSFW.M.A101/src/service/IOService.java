package service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import entity.Pet;

public class IOService {

	public void savePets(List<Pet> pets) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("pets.txt"))) {
			oos.writeObject(pets);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Pet> getPets() {
		List<Pet> pets = new ArrayList<>();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("pets.txt"))) {
			pets = (List<Pet>) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return pets;
	}

}
