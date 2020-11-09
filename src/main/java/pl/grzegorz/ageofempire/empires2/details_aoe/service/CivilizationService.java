package pl.grzegorz.ageofempire.empires2.details_aoe.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.grzegorz.ageofempire.empires2.app_loader.service.CivilizationTransformer;
import pl.grzegorz.ageofempire.empires2.common.repository.Civilization;
import pl.grzegorz.ageofempire.empires2.common.repository.CivilizationRepository;
import pl.grzegorz.ageofempire.empires2.common.service.NoSuchCivilizationExeption;

import java.util.List;

@Service
public class CivilizationService {

    private final CivilizationRepository civilizationRpository;
    private final CivilizationTransformer civilizationTransformer;

    @Autowired
    public CivilizationService(CivilizationRepository civilizationRpository, CivilizationTransformer civilizationTransformer) {
        this.civilizationRpository = civilizationRpository;
        this.civilizationTransformer = civilizationTransformer;
    }

    public List<Civilization> getCivilisations() {
        return civilizationRpository.findAll();
    }

    public Civilization getCivilizationByName(String name) {
        return civilizationRpository.findByName(name)
                .stream()
                .findAny()
                .orElseThrow(() -> {
                    throw new NoSuchCivilizationExeption(name);
                });
    }
}
