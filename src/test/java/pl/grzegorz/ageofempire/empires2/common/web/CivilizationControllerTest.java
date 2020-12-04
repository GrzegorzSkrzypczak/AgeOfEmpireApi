package pl.grzegorz.ageofempire.empires2.common.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import pl.grzegorz.ageofempire.empires2.app_loader.service.CivilizationService;
import pl.grzegorz.ageofempire.empires2.common.repository.Civilization;
import pl.grzegorz.ageofempire.empires2.common.repository.CivilizationRepository;
import pl.grzegorz.ageofempire.empires2.details_aoe.repository.CivilizationDetailsRepository;
import pl.grzegorz.ageofempire.empires2.details_aoe.repository.aoeapi.ApiCivilizationDetailsRepository;
import pl.grzegorz.ageofempire.empires2.details_aoe.service.CivilizationDetailsService;
import pl.grzegorz.ageofempire.empires2.details_aoe.service.CivilizationDetailsTransformer;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CivilizationController.class)
class CivilizationControllerTest {

    @TestConfiguration
    static class CivilizationControllerConfiguration {
        @Bean
        public CivilizationService civilizationService(CivilizationRepository civilizationRepository) {
            return new CivilizationService(civilizationRepository);
        }

        @Bean
        public CivilizationDetailsService civilizationDetailsService(CivilizationRepository civilizationRepository,
                                                                     ApiCivilizationDetailsRepository apiCivilizationDetailsRepository,
                                                                     CivilizationDetailsTransformer civilizationDetailsTransformer,
                                                                     CivilizationDetailsRepository civilizationDetailsRepository
        ) {
            return new CivilizationDetailsService(civilizationRepository,apiCivilizationDetailsRepository,
                    civilizationDetailsTransformer, civilizationDetailsRepository);
        }
    }

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CivilizationRepository civilizationRepository;
    @MockBean
    ApiCivilizationDetailsRepository apiCivilizationDetailsRepository;
    @MockBean
    CivilizationDetailsTransformer civilizationDetailsTransformer;
    @MockBean
    CivilizationDetailsRepository civilizationDetailsRepository;

    @Autowired
    CivilizationService civilizationService;

    @Autowired
    CivilizationDetailsService civilizationDetailsService;

    @Test
    void when_add_civilization_by_id_then_civilization_should_be_returned() throws Exception {

//        //given
//        String name = "Britons";
//        Civilization civ = new Civilization(2, name, "aztecs.url");
//        Mockito.when(civilizationService.getCivilizationByName(civ.getName())).thenReturn(civ);
//
//        //when
//
//        //then
//        mockMvc.perform(get("/civilizations").contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.id",equalTo(2)))
//                .andExpect(jsonPath("$.name",equalTo("Britons")))
//                .andExpect(status().isOk());


    }

    @Test
    void get_civilization_and_return_when_exist() throws Exception {
        //given
        String name = "Aztecs";
        List<Civilization> civilizations = new ArrayList<>();
        Civilization civ = new Civilization(1,name,"url.aztecs");
        civilizations.add(civ);

        //when
        Mockito.when(civilizationService.getCivilisations()).thenReturn(civilizations);

        //then
        mockMvc.perform(get("/civilizations")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.[0].name", equalTo("Aztecs")))
                .andExpect(jsonPath("$",hasSize(1)));
    }

}