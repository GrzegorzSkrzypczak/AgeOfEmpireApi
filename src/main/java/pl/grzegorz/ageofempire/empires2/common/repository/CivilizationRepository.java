package pl.grzegorz.ageofempire.empires2.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CivilizationRepository extends JpaRepository<Civilization, Integer> {

    Optional<Civilization> findByName(String name);

}
