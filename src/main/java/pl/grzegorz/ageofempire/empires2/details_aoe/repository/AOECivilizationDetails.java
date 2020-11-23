package pl.grzegorz.ageofempire.empires2.details_aoe.repository;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class AOECivilizationDetails {

    @Id
    private int id;
    private String expansion;
    @JsonProperty("army_type")
    private String armyType;

    @JsonProperty("unique_unit")
    @ElementCollection
    private List<String> uniqueUnit;

    @JsonProperty("civilization_bonus")
    @ElementCollection
    private List<String> civilizationBonus;

    public AOECivilizationDetails() {
    }

    public AOECivilizationDetails(int id, String expansion, String armyType, List<String> uniqueUnit, List<String> civilizationBonus) {
        this.id = id;
        this.expansion = expansion;
        this.armyType = armyType;
        this.uniqueUnit = uniqueUnit;
        this.civilizationBonus = civilizationBonus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
