package org.sergeok.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "laptop")
@NoArgsConstructor
@Getter
@Setter
public class Laptop extends Product {
    public enum ScreenDiagonal {
        _13,
        _14,
        _15,
        _17
    }

    private ScreenDiagonal screenDiagonal;
}