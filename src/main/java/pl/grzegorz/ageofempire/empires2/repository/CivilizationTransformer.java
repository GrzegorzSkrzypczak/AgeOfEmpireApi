package pl.grzegorz.ageofempire.empires2.repository;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CivilizationTransformer {

    public Civilization transformToCivilization(CivilisationResult civilisationResult) {
        return new Civilization(civilisationResult.getId(),civilisationResult.getName(), civilisationResult.getUrl());
    }

    public List<Civilization> transfromToCivilizationList(List<CivilisationResult> civilisationResultList) {
        return civilisationResultList.stream()
                .map(this::transformToCivilization)
                .collect(Collectors.toList());
    }
}
