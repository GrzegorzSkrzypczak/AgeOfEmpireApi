package pl.grzegorz.ageofempire.empires2.details_aoe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.grzegorz.ageofempire.empires2.common.service.NoSuchCivilizationExeption;
import pl.grzegorz.ageofempire.empires2.details_aoe.repository.AOECivilizationDetails;
import pl.grzegorz.ageofempire.empires2.details_aoe.repository.AOECivilizationDetailsRepository;

import java.util.List;

@Service
public class AOECivilizationDetailsService {

    private final AOECivilizationDetailsRepository aoeCivilizationDetailsRepository;

    @Autowired
    public AOECivilizationDetailsService(AOECivilizationDetailsRepository aoeCivilizationDetailsRepository) {
        this.aoeCivilizationDetailsRepository = aoeCivilizationDetailsRepository;

    }

    public List<AOECivilizationDetails> getCivilisationsDetails() {
        return aoeCivilizationDetailsRepository.findAll();
    }

    public AOECivilizationDetails getCivilizationDetailsByName(String name) {
        return aoeCivilizationDetailsRepository.findByName(name)
                .stream()
                .findAny()
                .orElseThrow(() -> {
                    throw new NoSuchCivilizationExeption(name);
                });
    }
}

