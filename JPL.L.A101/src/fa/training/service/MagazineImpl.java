package fa.training.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import fa.training.entities.Magazine;

public class MagazineImpl implements MagazineService {

	private List<Magazine> magazines = new ArrayList<>();

	@Override
	public void addMagazine(Magazine magazine) {
		magazines.add(magazine);
	}

	@Override
	public List<Magazine> getTop10MagazinesByVolume() {
		return magazines.stream().sorted(Comparator.comparingInt(Magazine::getVolume).reversed()).limit(10).toList();
	}

}
