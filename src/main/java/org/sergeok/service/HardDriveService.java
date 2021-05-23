package org.sergeok.service;

import org.sergeok.entity.HardDrive;
import org.sergeok.repository.HardDrivesDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HardDriveService extends AbstractProductService<HardDrive, HardDrivesDAO> {
    private final HardDrivesDAO hardDrivesDAO;

    public HardDriveService(HardDrivesDAO hardDrivesDAO) {
        super(hardDrivesDAO);
        this.hardDrivesDAO = hardDrivesDAO;
    }

    public List<HardDrive> readByCapacity(Long capacity) {
        return hardDrivesDAO.findByCapacity(capacity);
    }

    @Override
    public boolean updateBySerialNumber(HardDrive hardDrive) {
        HardDrive hardDriveFromDB = defaultUpdateBySerialNumber(hardDrive);
        if (hardDriveFromDB == null) {
            return false;
        }

        if (hardDrive.getCapacity() != null) {
            hardDriveFromDB.setCapacity(hardDrive.getCapacity());
        }

        hardDrivesDAO.save(hardDriveFromDB);
        return true;
    }
}
