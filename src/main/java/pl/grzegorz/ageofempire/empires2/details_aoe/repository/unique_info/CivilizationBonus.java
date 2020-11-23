package pl.grzegorz.ageofempire.empires2.details_aoe.repository.unique_info;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.ElementCollection;
import java.util.List;

public class CivilizationBonus {

    @JsonProperty("civilization_bonus")
    private String civilizationBonus;

    public String getCivilizationBonus() {
        return civilizationBonus;
    }
}
