package pl.grzegorz.ageofempire.empires2.app_loader.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.grzegorz.ageofempire.empires2.common.repository.Civilization;
import pl.grzegorz.ageofempire.empires2.common.repository.CivilizationRepository;
import pl.grzegorz.ageofempire.empires2.common.service.NoSuchCivilizationExeption;
import pl.grzegorz.ageofempire.empires2.details_aoe.repository.CivilizationDetails;
import pl.grzegorz.ageofempire.empires2.details_aoe.repository.CivilizationDetailsRepository;

import java.util.List;

@Service
public class CivilizationService {

    private final CivilizationRepository civilizationRpository;


    @Autowired
    public CivilizationService(CivilizationRepository civilizationRpository) {
        this.civilizationRpository = civilizationRpository;

    }

    public List<Civilization> getCivilisations() {
        return civilizationRpository.findAll();
    }

    public Civilization getCivilizationByName(String name) {
        return civilizationRpository.findById(name)
                .stream()
                .findAny()
                .orElseThrow(() -> {
                    throw new NoSuchCivilizationExeption(name);
                });
    }


}
