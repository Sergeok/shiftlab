package org.sergeok.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "hard_drive")
@NoArgsConstructor
@Getter
@Setter
public class HardDrive extends Product {
    private Long capacity;
}
