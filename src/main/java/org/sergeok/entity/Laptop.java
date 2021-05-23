package org.sergeok.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "laptop")
public class Laptop extends Product {
    public enum ScreenDiagonal {
        _13,
        _14,
        _15,
        _17
    }

    private ScreenDiagonal screenDiagonal;

    public Laptop() {
    }

    public ScreenDiagonal getScreenDiagonal() {
        return screenDiagonal;
    }

    public void setScreenDiagonal(ScreenDiagonal screenDiagonal) {
        this.screenDiagonal = screenDiagonal;
    }
}