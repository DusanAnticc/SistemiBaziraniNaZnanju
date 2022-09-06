package sbnz.integracija.example.service.contract;

import java.util.List;

import sbnz.integracija.example.model.ServiceLog;

public interface IServiceLogService {

    List<ServiceLog> findAll();

    ServiceLog findById(Long id);

    ServiceLog create(ServiceLog log);
}
