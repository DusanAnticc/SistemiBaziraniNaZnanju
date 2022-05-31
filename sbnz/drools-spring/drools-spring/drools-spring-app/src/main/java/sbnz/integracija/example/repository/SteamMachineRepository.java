package sbnz.integracija.example.repository;

import sbnz.integracija.example.model.SteamMachine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SteamMachineRepository extends JpaRepository<SteamMachine, Long> {

}
