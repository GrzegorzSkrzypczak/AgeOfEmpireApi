package pl.grzegorz.ageofempire.empires2.details_aoe.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.grzegorz.ageofempire.empires2.common.repository.Civilization;
import pl.grzegorz.ageofempire.empires2.common.repository.CivilizationRepository;
import pl.grzegorz.ageofempire.empires2.common.service.NoSuchCivilizationExeption;
import pl.grzegorz.ageofempire.empires2.details_aoe.repository.CivilizationDetails;
import pl.grzegorz.ageofempire.empires2.details_aoe.repository.CivilizationDetailsRepository;
import pl.grzegorz.ageofempire.empires2.details_aoe.repository.aoeapi.ApiCivilizationDetailsRepository;
import pl.grzegorz.ageofempire.empires2.details_aoe.repository.aoeapi.CivilizationDetailsResponse;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CivilizationDetailsService {

    private final CivilizationRepository civilizationRepository;
    private final ApiCivilizationDetailsRepository apiCivilizationDetailsRepository;
    private final CivilizationDetailsTransformer civilizationDetailsTransformer;
    private final CivilizationDetailsRepository civilizationDetailsRepository;

    @Autowired
    public CivilizationDetailsService(CivilizationRepository civilizationRepository,
                                      ApiCivilizationDetailsRepository apiCivilizationDetailsRepository,
                                      CivilizationDetailsTransformer civilizationDetailsTransformer,
                                      CivilizationDetailsRepository civilizationDetailsRepository) {
        this.civilizationRepository = civilizationRepository;
        this.apiCivilizationDetailsRepository = apiCivilizationDetailsRepository;
        this.civilizationDetailsTransformer = civilizationDetailsTransformer;
        this.civilizationDetailsRepository = civilizationDetailsRepository;
    }

    public CivilizationDetails getCivilizationDetails(String name) {
        Civilization civilization = civilizationRepository.findByName(name).orElseThrow(() -> {
            throw new NoSuchCivilizationExeption(name);
        });
        return provideCivilizationDetails(civilization);
    }

    public List<CivilizationDetails> getCivilizationDetailsList(List<String> civilizations) {
        List<CivilizationDetails> civilizationDetails = civilizations
                .stream()
                .map(civilizationRepository::findByName)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(this::provideCivilizationDetails)
                .collect(Collectors.toList());

        civilizationDetails.forEach(this::saveCivilizationDetailsRepo);
        return civilizationDetails;
    }


    private CivilizationDetails provideCivilizationDetails(Civilization civilization) {
        return civilizationDetailsRepository
                .findById(civilization.getName())
                .orElseGet(() ->{
                    CivilizationDetails civilizationDetails = getCivilizationDetailsFromApi(civilization.getUrl());
                    saveCivilizationDetailsRepo(civilizationDetails);
                    return civilizationDetails;
                });
    }

    private CivilizationDetails getCivilizationDetailsFromApi(String url) {
        CivilizationDetailsResponse response = apiCivilizationDetailsRepository.getCivilizationDetailsResponse(url);
        return civilizationDetailsTransformer.trancformToCivilization(response);
    }

    private void saveCivilizationDetailsRepo(CivilizationDetails details) {
        civilizationDetailsRepository.findById(details.getName())
                .orElseGet(() -> civilizationDetailsRepository.save(details));
    }
}

