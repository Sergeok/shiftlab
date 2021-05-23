package org.sergeok.api;

import org.sergeok.entity.HardDrive;
import org.sergeok.service.HardDriveService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/hdd")
public class HardDriveRestController extends AbstractProductRestController<HardDrive, HardDriveService> {
    private final HardDriveService hardDriveService;

    public HardDriveRestController(HardDriveService hardDriveService) {
        super(hardDriveService);
        this.hardDriveService = hardDriveService;
    }

    @Override
    public List<HardDrive> getProductsByProperty(@RequestBody HardDrive hardDrive) {
        if (hardDrive.getCapacity() != null) {
            return hardDriveService.readByCapacity(hardDrive.getCapacity());
        }

        return getProductsByDefaultProperty(hardDrive);
    }

    @Override
    public boolean setProduct(@RequestBody HardDrive requestedHardDrive) {
        if (requestedHardDrive.getSerialNumber() != null) {
            return hardDriveService.updateBySerialNumber(requestedHardDrive);
        }

        return false;
    }
}
