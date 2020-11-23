package pl.grzegorz.ageofempire.empires2.details_aoe.repository.unique_info;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.ElementCollection;
import java.util.List;

public class UniqueUnit {

    @JsonProperty("unique_unit")
    private  String uniqueUnit;

    public String getUniqueUnit() {
        return uniqueUnit;
    }
}
