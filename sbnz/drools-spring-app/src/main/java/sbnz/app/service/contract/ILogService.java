package sbnz.app.service.contract;


import sbnz.app.model.Log;

import java.util.List;

public interface ILogService {
    List<Log> findAll();

    Log findById(Long id);

    Log create(Log log);
}
