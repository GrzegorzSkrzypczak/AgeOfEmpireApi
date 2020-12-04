package pl.grzegorz.ageofempire.empires2.app_loader.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.grzegorz.ageofempire.empires2.common.repository.Civilization;
import pl.grzegorz.ageofempire.empires2.common.repository.CivilizationRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class CivilizationServiceTest {

    @TestConfiguration
    static class TestCivilizationServiceConfiguration {
        @Bean
        public CivilizationService civilizationService (CivilizationRepository civilizationRepository) {
            return new CivilizationService(civilizationRepository);
        }
    }

    @MockBean
    CivilizationRepository civilizationRepository;

    @Autowired
    CivilizationService civilizationService;

    @Test
    public void when_get_civilization_from_repo_by_name_then_should_be_returned() {
        //given
        String name = "Aztecs";
        Mockito.when(civilizationRepository.findById(name))
                .thenReturn(Optional.of(
                        new Civilization(1,"Aztecs","url")));

        //when
        Civilization civ = civilizationService.getCivilizationByName(name);

        //then
        assertEquals("Aztecs",civ.getName());
    }


}