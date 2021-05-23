package org.sergeok.repository;

import org.sergeok.entity.Laptop;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LaptopDAO extends ProductDAO<Laptop> {
    List<Laptop> findByScreenDiagonal(Laptop.ScreenDiagonal screenDiagonal);
}
