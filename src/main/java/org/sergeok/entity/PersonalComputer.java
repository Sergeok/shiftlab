package org.sergeok.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "personal_computer")
public class PersonalComputer extends Product {
    public enum FormFactor {
        DESKTOP,
        NETTOP,
        MONOBLOCK
    }

    private FormFactor formFactor;

    public PersonalComputer() {
    }

    public FormFactor getFormFactor() {
        return formFactor;
    }

    public void setFormFactor(FormFactor formFactor) {
        this.formFactor = formFactor;
    }
}
