package pl.grzegorz.ageofempire.empires2.details_aoe.repository.aoeapi.bonus;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CivilizationBonus {
    @JsonProperty("civilization_bonus")
    private BonusDetails civilizationBonus;

    public BonusDetails getCivilizationBonus() {
        return civilizationBonus;
    }

    public void setCivilizationBonus(BonusDetails civilizationBonus) {
        this.civilizationBonus = civilizationBonus;
    }
}
