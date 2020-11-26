package pl.grzegorz.ageofempire.empires2.details_aoe.repository.aoeapi;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.ElementCollection;
import java.util.List;

public class CivilizationDetailsResponse {

    private String name;
    private String expansion;
    @JsonProperty("army_type")
    private String armyType;

    @JsonProperty("unique_unit")
    @ElementCollection
    private List<String> uniqueUnit;

    @JsonProperty("civilization_bonus")
    @ElementCollection
    private List<String> civilizationBonus;

    public CivilizationDetailsResponse() {
    }

    public CivilizationDetailsResponse(String name, String expansion, String armyType, List<String> uniqueUnit, List<String> civilizationBonus) {
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

    public List<String> getUniqueUnit() {
        return uniqueUnit;
    }

    public void setUniqueUnit(List<String> uniqueUnit) {
        this.uniqueUnit = uniqueUnit;
    }

    public List<String> getCivilizationBonus() {
        return civilizationBonus;
    }

    public void setCivilizationBonus(List<String> civilizationBonus) {
        this.civilizationBonus = civilizationBonus;
    }
}
