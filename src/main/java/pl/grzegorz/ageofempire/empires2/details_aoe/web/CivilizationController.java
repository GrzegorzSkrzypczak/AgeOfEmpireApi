package pl.grzegorz.ageofempire.empires2.details_aoe.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.grzegorz.ageofempire.empires2.common.repository.Civilization;
import pl.grzegorz.ageofempire.empires2.app_loader.service.CivilizationService;
import pl.grzegorz.ageofempire.empires2.details_aoe.repository.AOECivilizationDetails;

import java.util.List;

@RequestMapping("/civilizations")
@RestController
public class CivilizationController {

    private final CivilizationService civilizationService;
    private final AOECivilizationDetails civilizationDetails;

    @Autowired
    public CivilizationController(CivilizationService civilizationService, AOECivilizationDetails civilizationDetails) {
        this.civilizationService = civilizationService;
        this.civilizationDetails = civilizationDetails;
    }

    @GetMapping
    @CrossOrigin
    public List<Civilization> getCivilizations() {
        return civilizationService.getCivilisations();
    }

//    @GetMapping("/{name}")
//    @CrossOrigin
//    public Civilization getByName(@PathVariable String name) {
//        return civilizationService.getCivilizationByName(name);
//
//    }

    @GetMapping("/{name}")
    @CrossOrigin
    public AOECivilizationDetails getByName(@PathVariable String name) {

        //TODO zrobic respone iResttemplate zeby dzialolo jak w pokemon api
        return civilizationDetails.getCivilizationByName(name);

    }


}
