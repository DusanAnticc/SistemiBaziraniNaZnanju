package sbnz.integracija.example.service.contract;

import sbnz.integracija.example.model.Guest;

public interface IGuestService {

	public Long PayBill(Long userid);

	Long setProducedEnergy(Long userId, Long value);
}
