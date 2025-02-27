package fa.training.service;

import java.util.List;

import fa.training.entities.Magazine;

public interface MagazineService {
	
	 void addMagazine(Magazine magazine);
	 List<Magazine> getTop10MagazinesByVolume();
	
}
