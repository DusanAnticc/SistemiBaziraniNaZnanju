package sbnz.integracija.example.repository;

import sbnz.integracija.example.model.ServiceLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceLogRepository extends JpaRepository<ServiceLog, Long> {

}
