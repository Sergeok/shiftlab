package org.sergeok.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "hard_drive")
public class HardDrive extends Product {
    private Long capacity;

    public HardDrive() {
    }

    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }
}
