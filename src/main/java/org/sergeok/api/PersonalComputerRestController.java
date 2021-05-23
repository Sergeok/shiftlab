package org.sergeok.api;

import org.sergeok.entity.PersonalComputer;
import org.sergeok.service.PersonalComputerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pc")
public class PersonalComputerRestController extends AbstractProductRestController<PersonalComputer, PersonalComputerService> {
    private final PersonalComputerService personalComputerService;

    public PersonalComputerRestController(PersonalComputerService personalComputerService) {
        super(personalComputerService);
        this.personalComputerService = personalComputerService;
    }

    @Override
    public List<PersonalComputer> getProductsByProperty(@RequestBody PersonalComputer pc) {
        if (pc.getFormFactor() != null) {
            return personalComputerService.readPersonalComputerByFormFactor(pc.getFormFactor());
        }

        return getProductsByDefaultProperty(pc);
    }

    @Override
    public boolean setProduct(@RequestBody PersonalComputer requestedPC) {
        if (requestedPC.getSerialNumber() != null) {
            return personalComputerService.updateBySerialNumber(requestedPC);
        }

        return false;
    }
}