package org.sergeok.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "monitor")
public class Monitor extends Product {
    private Long diagonal;

    public Monitor() {
    }

    public Long getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(Long diagonal) {
        this.diagonal = diagonal;
    }
}
