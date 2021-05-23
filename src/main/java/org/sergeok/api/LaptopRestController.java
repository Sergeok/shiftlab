package org.sergeok.api;

import org.sergeok.entity.Laptop;
import org.sergeok.service.LaptopService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/laptop")
public class LaptopRestController extends AbstractProductRestController<Laptop, LaptopService> {
    private final LaptopService laptopService;

    public LaptopRestController(LaptopService laptopService) {
        super(laptopService);
        this.laptopService = laptopService;
    }

    @Override
    public List<Laptop> getProductsByProperty(@RequestBody Laptop laptop) {
        if (laptop.getScreenDiagonal() != null) {
            return laptopService.readByScreenDiagonal(laptop.getScreenDiagonal());
        }

        return getProductsByDefaultProperty(laptop);
    }

    @Override
    public boolean setProduct(@RequestBody Laptop requestedLaptop) {
        if (requestedLaptop.getSerialNumber() != null) {
            return laptopService.updateBySerialNumber(requestedLaptop);
        }

        return false;
    }
}
