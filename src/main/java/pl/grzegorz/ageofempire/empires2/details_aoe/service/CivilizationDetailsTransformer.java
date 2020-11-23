package pl.grzegorz.ageofempire.empires2.details_aoe.service;

import org.springframework.stereotype.Component;
import pl.grzegorz.ageofempire.empires2.details_aoe.repository.CivilizationDetails;
import pl.grzegorz.ageofempire.empires2.details_aoe.repository.aoeapi.CivilizationDetailsResponse;
import pl.grzegorz.ageofempire.empires2.details_aoe.repository.aoeapi.bonus.CivilizationBonus;
import pl.grzegorz.ageofempire.empires2.details_aoe.repository.aoeapi.units.UnitDetails;
import pl.grzegorz.ageofempire.empires2.details_aoe.repository.aoeapi.units.UnitUnits;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CivilizationDetailsTransformer {

    public CivilizationDetails trancformToCivilization(CivilizationDetailsResponse civilizationDetailsResponse) {
        String name = civilizationDetailsResponse.getName();
        String expansion = civilizationDetailsResponse.getExpansion();
        String armyType = civilizationDetailsResponse.getArmyType();
        List<String> uniqueUnits = civilizationDetailsResponse.getUniqueUnit()
                .stream()
                .map(units ->units.getUnitsDetails().getUnitsDetails())
                .collect(Collectors.toList());

        List<String> civilizationBonus =civilizationDetailsResponse.getCivilizationBonus()
                .stream()
                .map(bonus -> bonus.getCivilizationBonus().getBonus())
                .collect(Collectors.toList());

        return new CivilizationDetails(name,expansion,armyType,uniqueUnits,civilizationBonus);
    }
}
