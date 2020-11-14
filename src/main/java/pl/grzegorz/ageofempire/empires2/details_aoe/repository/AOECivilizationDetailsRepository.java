package pl.grzegorz.ageofempire.empires2.details_aoe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.grzegorz.ageofempire.empires2.common.repository.Civilization;

import java.util.Optional;

public interface AOECivilizationDetailsRepository extends JpaRepository<AOECivilizationDetails, String> {

    Optional<AOECivilizationDetails> findByName(String name);
}
