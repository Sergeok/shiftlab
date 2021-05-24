package org.sergeok.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@MappedSuperclass
@NoArgsConstructor
@Getter
@Setter
public abstract class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private Long serialNumber;
    private String manufacturer;
    private Long price;
    private Long unitsInStock;
}
