package pl.grzegorz.ageofempire.empires2.app_loader.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pl.grzegorz.ageofempire.empires2.app_loader.repository.CivilisationResult;
import pl.grzegorz.ageofempire.empires2.common.repository.Civilization;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CivilizationTransformer {

    @Value("${civilizationcontroller.url}")
    private String url;


    public Civilization transformToCivilization(CivilisationResult civilisationResult) {
        return new Civilization(civilisationResult.getId(), civilisationResult.getName(), url + civilisationResult.getId());
    }

    public List<Civilization> transfromToCivilizationList(List<CivilisationResult> civilisationResultList) {
        return civilisationResultList.stream()
                .map(this::transformToCivilization)
                .collect(Collectors.toList());
    }
}
