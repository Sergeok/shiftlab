package org.sergeok.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "monitor")
@NoArgsConstructor
@Getter
@Setter
public class Monitor extends Product {
    private Long diagonal;
}
