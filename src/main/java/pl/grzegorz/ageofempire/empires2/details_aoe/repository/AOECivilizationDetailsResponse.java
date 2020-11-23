package pl.grzegorz.ageofempire.empires2.details_aoe.repository;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Repository;
import pl.grzegorz.ageofempire.empires2.details_aoe.repository.unique_info.CivilizationBonus;
import pl.grzegorz.ageofempire.empires2.details_aoe.repository.unique_info.UniqueUnit;

import javax.persistence.ElementCollection;
import java.util.List;

@Repository
public class AOECivilizationDetailsResponse {

    private int id;
    private String expansion;
    @JsonProperty("army_type")
    private String armyType;

    @JsonProperty("unique_unit")
    private List<UniqueUnit> uniqueUnit;

    @JsonProperty("civilization_bonus")
    @ElementCollection
    private List<CivilizationBonus> civilizationBonus;

    public AOECivilizationDetailsResponse() {
    }

    public AOECivilizationDetailsResponse(int id, String expansion, String armyType, List<UniqueUnit> uniqueUnit, List<CivilizationBonus> civilizationBonus) {
        
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

    public List<UniqueUnit> getUniqueUnit() {
        return uniqueUnit;
    }

    public void setUniqueUnit(List<UniqueUnit> uniqueUnit) {
        this.uniqueUnit = uniqueUnit;
    }

    public List<CivilizationBonus> getCivilizationBonus() {
        return civilizationBonus;
    }

    public void setCivilizationBonus(List<CivilizationBonus> civilizationBonus) {
        this.civilizationBonus = civilizationBonus;
    }
}
