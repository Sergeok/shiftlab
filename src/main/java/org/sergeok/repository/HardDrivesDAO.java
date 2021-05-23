package org.sergeok.repository;

import org.sergeok.entity.HardDrive;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HardDrivesDAO extends ProductDAO<HardDrive> {
    List<HardDrive> findByCapacity(Long capacity);
}
