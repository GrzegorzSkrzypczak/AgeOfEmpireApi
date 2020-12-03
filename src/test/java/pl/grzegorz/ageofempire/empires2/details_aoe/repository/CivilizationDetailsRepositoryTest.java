package pl.grzegorz.ageofempire.empires2.details_aoe.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class CivilizationDetailsRepositoryTest {

    @Autowired
    CivilizationDetailsRepository civilizationDetailsRepository;

    @Autowired
    TestEntityManager testEntityManager;


    @BeforeEach
    void setUp() {
        List<String> units = List.of("Jaguar Warriors");
        List<String> bonus = List.of("Villagers carry +5", "Military units created 15% faster", "Loom free");

        CivilizationDetails civ_1 = new CivilizationDetails("Aztecs",
                "The Conquerors",
                "Wariors",
                units, bonus);
        testEntityManager.persist(civ_1);
    }

    @Test
    void find_civilization_details_by_expansion_and_return_one(){
        //given
        String expansion = "The Conquerors";
        //when
        Optional<CivilizationDetails> civilizationDetails = civilizationDetailsRepository.
                findCivilizationDetailsByExpansion(expansion);

        //then
        assertTrue(civilizationDetails.isPresent());
        assertEquals(expansion,civilizationDetails.get().getExpansion());
    }



}