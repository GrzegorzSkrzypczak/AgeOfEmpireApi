package pl.grzegorz.ageofempire.empires2.common.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import pl.grzegorz.ageofempire.empires2.app_loader.service.CivilizationService;
import pl.grzegorz.ageofempire.empires2.common.repository.Civilization;
import pl.grzegorz.ageofempire.empires2.details_aoe.service.CivilizationDetailsService;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CivilizationController.class)
class CivilizationControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CivilizationService civilizationService;

    @MockBean
    CivilizationDetailsService civilizationDetailsService;

    @Test
    void when_add_civilization_by_id_then_civilization_should_be_returned() throws Exception {
//
//        //given
//        String name = "Aztecs";
//        Civilization civilization_1 = new Civilization(1, name, "aztecs.url");
//        Mockito.when(civilizationService.getCivilizationByName(name)).thenReturn(civilization_1);
//
//        //when
//
//        //then
//        mockMvc.perform(get("https://age-of-empires-2-api.herokuapp.com/api/v1/civilization/").contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.id",equalTo(1)))
//                .andExpect(jsonPath("$.name",equalTo("Aztecs")))
//                .andExpect(status().isOk());
//
    }

}