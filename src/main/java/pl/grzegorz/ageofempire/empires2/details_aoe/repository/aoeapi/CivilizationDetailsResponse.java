package pl.grzegorz.ageofempire.empires2.details_aoe.repository.aoeapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import pl.grzegorz.ageofempire.empires2.details_aoe.repository.aoeapi.bonus.CivilizationBonus;
import pl.grzegorz.ageofempire.empires2.details_aoe.repository.aoeapi.units.UnitUnits;

import javax.persistence.ElementCollection;
import java.util.List;

public class CivilizationDetailsResponse {

    private String name;
    private String expansion;
    @JsonProperty("army_type")
    private String armyType;

    @JsonProperty("unique_unit")
    @ElementCollection
    private List<UnitUnits> uniqueUnit;

    @JsonProperty("civilization_bonus")
    @ElementCollection
    private List<CivilizationBonus> civilizationBonus;

    public CivilizationDetailsResponse() {
    }

    public CivilizationDetailsResponse(String name, String expansion, String armyType, List<UnitUnits> uniqueUnit, List<CivilizationBonus> civilizationBonus) {
        this.name = name;
        this.expansion = expansion;
        this.armyType = armyType;
        this.uniqueUnit = uniqueUnit;
        this.civilizationBonus = civilizationBonus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpansion() {
        return expansion;
    }

    public void setExpansion(String expansion) {
        this.expansion = expansion;
    }

    public String getArmyType() {
        return armyType;
    }

    public void setArmyType(String armyType) {
        this.armyType = armyType;
    }

    public List<UnitUnits> getUniqueUnit() {
        return uniqueUnit;
    }

    public void setUniqueUnit(List<UnitUnits> uniqueUnit) {
        this.uniqueUnit = uniqueUnit;
    }

    public List<CivilizationBonus> getCivilizationBonus() {
        return civilizationBonus;
    }

    public void setCivilizationBonus(List<CivilizationBonus> civilizationBonus) {
        this.civilizationBonus = civilizationBonus;
    }
}
