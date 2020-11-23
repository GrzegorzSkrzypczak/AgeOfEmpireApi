package pl.grzegorz.ageofempire.empires2.details_aoe.repository.aoeapi.units;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UnitUnits {

    @JsonProperty("civilization_bonus")
    private UnitDetails unitsDetails;

    public UnitDetails getUnitsDetails() {
        return unitsDetails;
    }

    public void setUnitsDetails(UnitDetails unitsDetails) {
        this.unitsDetails = unitsDetails;
    }
}
