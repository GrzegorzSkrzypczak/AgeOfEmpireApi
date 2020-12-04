package pl.grzegorz.ageofempire.empires2.details_aoe.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.grzegorz.ageofempire.empires2.common.repository.CivilizationRepository;
import pl.grzegorz.ageofempire.empires2.details_aoe.repository.CivilizationDetails;
import pl.grzegorz.ageofempire.empires2.details_aoe.repository.CivilizationDetailsRepository;
import pl.grzegorz.ageofempire.empires2.details_aoe.repository.aoeapi.ApiCivilizationDetailsRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class CivilizationDetailsServiceTest {

    @TestConfiguration
    static class TestCivilizationDetailsServiceConfiguration {
        @Bean
        public CivilizationDetailsService civilizationDetailsService (
                CivilizationRepository civilizationRepository,
                ApiCivilizationDetailsRepository apiCivilizationDetailsRepository,
                CivilizationDetailsTransformer civilizationDetailsTransformer,
                CivilizationDetailsRepository civilizationDetailsRepository
                ) {
            return new CivilizationDetailsService(civilizationRepository,apiCivilizationDetailsRepository,
                    civilizationDetailsTransformer, civilizationDetailsRepository);
        }
    }

    @MockBean
    CivilizationRepository civilizationRepository;
    @MockBean
    ApiCivilizationDetailsRepository apiCivilizationDetailsRepository;
    @MockBean
    CivilizationDetailsTransformer civilizationDetailsTransformer;
    @MockBean
    CivilizationDetailsRepository civilizationDetailsRepository;

    @Autowired
    CivilizationDetailsService civilizationDetailsService;

    @Test
    public void when_get_civilizatio_details_Expansion_name_then_return_civilization_details(){
        //given
        String expName = "The Conquerors";
        List<String> units = List.of("Jaguar Warriors");
        List<String> bonus = List.of("Villagers carry +5", "Military units created 15% faster", "Loom free");

        Mockito.when(civilizationDetailsRepository.findCivilizationDetailsByExpansion(expName))
                .thenReturn(Optional.of(new CivilizationDetails("Name",
                        "The Conquerors",
                        "ArmyType",
                        units,
                        bonus)));

        //when
        CivilizationDetails civilizationDetails = civilizationDetailsService.getCivilizationDetailsByExpansion(expName);

        //then
        assertEquals(expName, civilizationDetails.getExpansion());
    }



}