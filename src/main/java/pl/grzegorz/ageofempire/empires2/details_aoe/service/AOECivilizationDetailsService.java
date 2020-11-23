package pl.grzegorz.ageofempire.empires2.details_aoe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.grzegorz.ageofempire.empires2.app_loader.service.CivilizationTransformer;
import pl.grzegorz.ageofempire.empires2.common.repository.Civilization;
import pl.grzegorz.ageofempire.empires2.common.repository.CivilizationRepository;
import pl.grzegorz.ageofempire.empires2.common.service.NoSuchCivilizationExeption;
import pl.grzegorz.ageofempire.empires2.details_aoe.repository.AOECivilizationDetails;
import pl.grzegorz.ageofempire.empires2.details_aoe.repository.AOECivilizationDetailsRepository;
import pl.grzegorz.ageofempire.empires2.details_aoe.repository.AOECivilizationDetailsResponse;
import pl.grzegorz.ageofempire.empires2.details_aoe.repository.AgeOfEmpiresAPIRepository;

import java.util.List;

@Service
public class AOECivilizationDetailsService {

    private final AOECivilizationDetailsRepository aoeCivilizationDetailsRepository;
    private final CivilizationRepository civilizationRepository;
    private final AgeOfEmpiresAPIRepository ageOfEmpiresAPIRepository;
    private final CivilizationTransformer civilizationTransformer;

    @Autowired
    public AOECivilizationDetailsService(AOECivilizationDetailsRepository aoeCivilizationDetailsRepository, CivilizationRepository civilizationRepository, AgeOfEmpiresAPIRepository ageOfEmpiresAPIRepository, CivilizationTransformer civilizationTransformer) {
        this.aoeCivilizationDetailsRepository = aoeCivilizationDetailsRepository;
        this.civilizationRepository = civilizationRepository;
        this.ageOfEmpiresAPIRepository = ageOfEmpiresAPIRepository;
        this.civilizationTransformer = civilizationTransformer;
    }

    public List<AOECivilizationDetails> getCivilisationsDetails() {
        return aoeCivilizationDetailsRepository.findAll();
    }

    public AOECivilizationDetails getCivilizationDetailsById(int id) {
        Civilization civilization =  civilizationRepository.findById(id).orElseThrow(() -> {
            throw new NoSuchCivilizationExeption("Nie ma takiej cywki");
        });
        return p
    }

    public void getCivilizationDetailsFromApi (String url) {
        AOECivilizationDetailsResponse response = ageOfEmpiresAPIRepository.getCivilizationDetailsResponse(url);
        return civilizationTransformer.transformToCivilization(response);
    }
}

