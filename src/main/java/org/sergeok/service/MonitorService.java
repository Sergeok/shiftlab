package org.sergeok.service;

import org.sergeok.entity.Monitor;
import org.sergeok.repository.MonitorDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonitorService extends AbstractProductService<Monitor, MonitorDAO> {
    private final MonitorDAO monitorDAO;

    public MonitorService(MonitorDAO monitorDAO) {
        super(monitorDAO);
        this.monitorDAO = monitorDAO;
    }

    public List<Monitor> readMonitorByDiagonal(Long diagonal) {
        return monitorDAO.findByDiagonal(diagonal);
    }

    @Override
    public boolean updateBySerialNumber(Monitor monitor) {
        Monitor monitorFromDB = defaultUpdateBySerialNumber(monitor);
        if (monitorFromDB == null) {
            return false;
        }

        if (monitor.getDiagonal() != null) {
            monitorFromDB.setDiagonal(monitor.getDiagonal());
        }

        monitorDAO.save(monitorFromDB);
        return true;
    }
}
