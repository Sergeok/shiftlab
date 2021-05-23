package org.sergeok.api;

import org.sergeok.entity.Monitor;
import org.sergeok.service.MonitorService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/monitor")
public class MonitorRestController extends AbstractProductRestController<Monitor, MonitorService> {
    private final MonitorService monitorService;

    public MonitorRestController(MonitorService monitorService) {
        super(monitorService);
        this.monitorService = monitorService;
    }

    @Override
    public List<Monitor> getProductsByProperty(@RequestBody Monitor monitor) {
        if (monitor.getDiagonal() != null) {
            return monitorService.readMonitorByDiagonal(monitor.getDiagonal());
        }

        return getProductsByDefaultProperty(monitor);
    }

    @Override
    public boolean setProduct(@RequestBody Monitor requestedMonitor) {
        if (requestedMonitor.getSerialNumber() != null) {
            return monitorService.updateBySerialNumber(requestedMonitor);
        }

        return false;
    }
}
