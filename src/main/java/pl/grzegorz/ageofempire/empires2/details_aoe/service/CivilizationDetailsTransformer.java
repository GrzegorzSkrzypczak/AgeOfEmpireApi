package pl.grzegorz.ageofempire.empires2.details_aoe.service;

import org.springframework.stereotype.Component;
import pl.grzegorz.ageofempire.empires2.details_aoe.repository.CivilizationDetails;
import pl.grzegorz.ageofempire.empires2.details_aoe.repository.aoeapi.CivilizationDetailsResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CivilizationDetailsTransformer {

    public CivilizationDetails trancformToCivilization(CivilizationDetailsResponse civilizationDetailsResponse) {
        String name = civilizationDetailsResponse.getName();
        String expansion = civilizationDetailsResponse.getExpansion();
        String armyType = civilizationDetailsResponse.getArmyType();

        List<String> uniqueUnits = new ArrayList<>(civilizationDetailsResponse.getUniqueUnit());

        List<String> civilizationBonus = new ArrayList<>(civilizationDetailsResponse.getCivilizationBonus());

        return new CivilizationDetails(name,expansion,armyType,uniqueUnits,civilizationBonus);
    }
}
