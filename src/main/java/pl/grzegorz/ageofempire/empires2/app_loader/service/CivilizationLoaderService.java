package pl.grzegorz.ageofempire.empires2.app_loader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.grzegorz.ageofempire.empires2.app_loader.repository.AgeOfEmpiresRepository;
import pl.grzegorz.ageofempire.empires2.app_loader.repository.CivilisationRepositoryResponse;
import pl.grzegorz.ageofempire.empires2.app_loader.repository.CivilisationResult;
import pl.grzegorz.ageofempire.empires2.common.repository.Civilization;
import pl.grzegorz.ageofempire.empires2.common.repository.CivilizationRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class CivilizationLoaderService {

    private final CivilizationRepository civilizationRepository;
    private final AgeOfEmpiresRepository ageOfEmpiresRepository;
    private final CivilizationTransformer civilizationTransformer;

    @Autowired
    public CivilizationLoaderService(CivilizationRepository civilizationRepository,
                                     AgeOfEmpiresRepository ageOfEmpiresRepository, CivilizationTransformer civilizationTransformer) {
        this.civilizationRepository = civilizationRepository;
        this.ageOfEmpiresRepository = ageOfEmpiresRepository;
        this.civilizationTransformer = civilizationTransformer;
    }

    @PostConstruct
    public void loadCivlizations() {
        CivilisationRepositoryResponse civilisationResponse;

        civilisationResponse = ageOfEmpiresRepository.getCivilizations();
        List<CivilisationResult> civilisationResultList = new ArrayList<>(civilisationResponse.getCivilizations());

        List<Civilization> civilizations = civilizationTransformer.transfromToCivilizationList(civilisationResultList);
        civilizationRepository.saveAll(civilizations);

    }


}
