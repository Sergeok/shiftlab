package org.sergeok.service;

import org.sergeok.entity.PersonalComputer;
import org.sergeok.repository.PersonalComputerDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalComputerService extends AbstractProductService<PersonalComputer, PersonalComputerDAO> {
    private final PersonalComputerDAO personalComputerDAO;

    public PersonalComputerService(PersonalComputerDAO personalComputerDAO) {

        super(personalComputerDAO);
        this.personalComputerDAO = personalComputerDAO;
    }

    public List<PersonalComputer> readPersonalComputerByFormFactor(PersonalComputer.FormFactor formFactor) {
        return personalComputerDAO.findByFormFactor(formFactor);
    }

    @Override
    public boolean updateBySerialNumber(PersonalComputer pc) {
        PersonalComputer pcFromDB = defaultUpdateBySerialNumber(pc);
        if (pcFromDB == null) {
            return false;
        }

        if (pc.getFormFactor() != null) {
            pcFromDB.setFormFactor(pc.getFormFactor());
        }

        personalComputerDAO.save(pcFromDB);
        return true;
    }
}