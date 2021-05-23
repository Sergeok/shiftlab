package org.sergeok.repository;

import org.sergeok.entity.Monitor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MonitorDAO extends ProductDAO<Monitor> {
    List<Monitor> findByDiagonal(Long diagonal);
}
