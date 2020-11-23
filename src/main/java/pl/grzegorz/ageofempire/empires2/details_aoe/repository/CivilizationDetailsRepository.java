package pl.grzegorz.ageofempire.empires2.details_aoe.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface CivilizationDetailsRepository extends CrudRepository<CivilizationDetails, String> {
    Optional<CivilizationDetails> getCivilizationDetailsByName(String name);

}
