package org.sergeok.service;

import org.sergeok.entity.Laptop;
import org.sergeok.repository.LaptopDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopService extends AbstractProductService<Laptop, LaptopDAO> {
    private final LaptopDAO laptopDAO;

    public LaptopService(LaptopDAO laptopDAO) {

        super(laptopDAO);
        this.laptopDAO = laptopDAO;
    }

    public List<Laptop> readByScreenDiagonal(Laptop.ScreenDiagonal screenDiagonal) {
        return laptopDAO.findByScreenDiagonal(screenDiagonal);
    }

    @Override
    public boolean updateBySerialNumber(Laptop laptop) {
        Laptop laptopFromDB = defaultUpdateBySerialNumber(laptop);
        if (laptopFromDB == null) {
            return false;
        }

        if (laptop.getScreenDiagonal() != null) {
            laptopFromDB.setScreenDiagonal(laptop.getScreenDiagonal());
        }

        laptopDAO.save(laptopFromDB);
        return true;
    }
}
