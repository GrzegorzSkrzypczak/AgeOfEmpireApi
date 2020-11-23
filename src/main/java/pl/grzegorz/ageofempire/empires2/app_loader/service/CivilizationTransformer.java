package pl.grzegorz.ageofempire.empires2.app_loader.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pl.grzegorz.ageofempire.empires2.app_loader.repository.CivilisationResult;
import pl.grzegorz.ageofempire.empires2.common.repository.Civilization;
import pl.grzegorz.ageofempire.empires2.details_aoe.repository.AOECivilizationDetails;
import pl.grzegorz.ageofempire.empires2.details_aoe.repository.AOECivilizationDetailsResponse;
import pl.grzegorz.ageofempire.empires2.details_aoe.repository.unique_info.CivilizationBonus;
import pl.grzegorz.ageofempire.empires2.details_aoe.repository.unique_info.UniqueUnit;

import javax.persistence.ElementCollection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
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

    public AOECivilizationDetails transformToCivilizationDetails(AOECivilizationDetailsResponse aoeCivilizationDetailsResponse) {
        int id = aoeCivilizationDetailsResponse.getId();
        String expansion = aoeCivilizationDetailsResponse.getExpansion();
        String armyType = aoeCivilizationDetailsResponse.getArmyType();
        List<String> uniqueUnit = aoeCivilizationDetailsResponse.getUniqueUnit()
                .stream()
                .map(unit -> unit.getUniqueUnit())
                .collect(Collectors.toList());
        List<String> civilizationBonus = aoeCivilizationDetailsResponse.getCivilizationBonus()
                .stream()
                .map(bonus -> bonus.getCivilizationBonus())
                .collect(Collectors.toList());

        return new AOECivilizationDetails(id, expansion,armyType,uniqueUnit,civilizationBonus);

    }
}
