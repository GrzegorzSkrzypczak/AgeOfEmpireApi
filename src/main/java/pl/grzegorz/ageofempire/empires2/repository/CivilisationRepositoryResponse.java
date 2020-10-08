package pl.grzegorz.ageofempire.empires2.repository;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CivilisationRepositoryResponse {

    private List<CivilisationResult> civilizations;

    public List<CivilisationResult> getCivilizations() {
        return civilizations;
    }

    public void setCivilizations(List<CivilisationResult> civilizations) {
        this.civilizations = civilizations;
    }
}
