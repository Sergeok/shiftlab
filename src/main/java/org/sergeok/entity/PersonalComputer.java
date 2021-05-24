package org.sergeok.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "personal_computer")
@NoArgsConstructor
@Getter
@Setter
public class PersonalComputer extends Product {
    public enum FormFactor {
        DESKTOP,
        NETTOP,
        MONOBLOCK
    }

    private FormFactor formFactor;
}
