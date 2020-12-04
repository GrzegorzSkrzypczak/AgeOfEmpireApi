package pl.grzegorz.ageofempire.empires2.common.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class CivilizationRepositoryTest {

    @Autowired
    CivilizationRepository civilizationRepository;
    @Autowired
    TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        Civilization civilization_1 = new Civilization(1, "Aztecs", "aztecs.url");
        Civilization civilization_2 = new Civilization(2, "Britons", "britons.url");
        testEntityManager.persist(civilization_1);
        testEntityManager.persist(civilization_2);
    }


    @Test
    void when_searching_civilization_by_name_return_one() {
        //given
        String name = "Aztecs";
        String name2 = "Britons";

        //when
        Optional<Civilization> civilizations = civilizationRepository.findById(name2);
        Optional<Civilization> civilization = civilizationRepository.findById(name);

        //then
        assertTrue(civilizations.isPresent());
        assertEquals(name, civilization.get().getName());
        assertEquals(name2, civilizations.get().getName());

    }

}