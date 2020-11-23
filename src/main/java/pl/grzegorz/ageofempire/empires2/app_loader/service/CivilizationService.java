package pl.grzegorz.ageofempire.empires2.app_loader.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.grzegorz.ageofempire.empires2.common.repository.Civilization;
import pl.grzegorz.ageofempire.empires2.common.repository.CivilizationRepository;
import pl.grzegorz.ageofempire.empires2.common.service.NoSuchCivilizationExeption;
import pl.grzegorz.ageofempire.empires2.details_aoe.repository.AOECivilizationDetails;
import pl.grzegorz.ageofempire.empires2.details_aoe.repository.AOECivilizationDetailsRepository;

import java.util.List;

@Service
public class CivilizationService {

    private final CivilizationRepository civilizationRpository;
    private final CivilizationTransformer civilizationTransformer;
    private final AOECivilizationDetailsRepository aoeCivilizationDetailsRepository;

    @Autowired
    public CivilizationService(CivilizationRepository civilizationRpository, CivilizationTransformer civilizationTransformer, AOECivilizationDetailsRepository aoeCivilizationDetailsRepository) {
        this.civilizationRpository = civilizationRpository;
        this.civilizationTransformer = civilizationTransformer;
        this.aoeCivilizationDetailsRepository = aoeCivilizationDetailsRepository;
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

    public AOECivilizationDetails getCivilizationDetailsByName(int id) {
        return aoeCivilizationDetailsRepository.findById(id)
                .stream()
                .findAny()
                .orElseGet(() -> {throw new NoSuchCivilizationExeption("nie ma");
    });
    }
}
