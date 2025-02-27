package view;

import java.util.ArrayList;
import java.util.List;

import entity.Pet;
import service.IOService;

public class Test {

	private static IOService iOService;

	public static void main(String[] args) {
		iOService = new IOService();

		List<Pet> pets = new ArrayList<>();
		pets.add(new Pet("Mowzer", "cat", 3));
		pets.add(new Pet("Rex", "dog", 5));

		iOService.savePets(pets);

		List<Pet> savedPets = iOService.getPets();

		for (Pet pet : savedPets) {
			pet.makeNoise();
		}
	}

}
