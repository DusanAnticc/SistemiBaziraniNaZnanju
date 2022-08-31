package sbnz.integracija.example.repository;

import sbnz.integracija.example.model.LogTemperatures;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogTemperatureRepository extends JpaRepository<LogTemperatures, Long> {

}
