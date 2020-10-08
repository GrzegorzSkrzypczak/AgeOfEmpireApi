package pl.grzegorz.ageofempire.empires2.service;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.grzegorz.ageofempire.empires2.repository.Civilization;

import java.util.Optional;

public interface CivilizationRepository extends JpaRepository<Civilization, Integer> {

    Optional<Civilization> findByName(String name);

}
