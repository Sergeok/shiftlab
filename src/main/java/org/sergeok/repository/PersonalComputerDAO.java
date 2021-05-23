package org.sergeok.repository;

import org.sergeok.entity.PersonalComputer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonalComputerDAO extends ProductDAO<PersonalComputer> {
    List<PersonalComputer> findByFormFactor(PersonalComputer.FormFactor formFactor);
}