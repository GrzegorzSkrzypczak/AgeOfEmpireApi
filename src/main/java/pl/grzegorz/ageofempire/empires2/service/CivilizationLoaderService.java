package pl.grzegorz.ageofempire.empires2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.grzegorz.ageofempire.empires2.repository.*;

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
        List<CivilisationResult> civilisationResultList = new ArrayList<>();
        CivilisationRepositoryResponse civilisationResponse;

        civilisationResponse = ageOfEmpiresRepository.getCivilizations();
        civilisationResultList.addAll(civilisationResponse.getCivilizations());

        List<Civilization> civilizations = civilizationTransformer.transfromToCivilizationList(civilisationResultList);
        civilizationRepository.saveAll(civilizations);

    }


}
