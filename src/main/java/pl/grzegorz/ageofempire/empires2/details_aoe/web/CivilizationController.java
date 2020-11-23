package pl.grzegorz.ageofempire.empires2.details_aoe.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.grzegorz.ageofempire.empires2.common.repository.Civilization;
import pl.grzegorz.ageofempire.empires2.app_loader.service.CivilizationService;
import pl.grzegorz.ageofempire.empires2.details_aoe.repository.AOECivilizationDetails;
import pl.grzegorz.ageofempire.empires2.details_aoe.service.AOECivilizationDetailsService;

import java.util.List;

@RequestMapping("/civilizations")
@RestController
public class CivilizationController {

    private final CivilizationService civilizationService;

    @Autowired
    public CivilizationController(CivilizationService civilizationService) {
        this.civilizationService = civilizationService;
    }

    @GetMapping
    @CrossOrigin
    public List<Civilization> getCivilizations() {
        return civilizationService.getCivilisations();
    }

    @GetMapping("/{name}")
    @CrossOrigin
    public Civilization getByName(@PathVariable String name) {
        return civilizationService.getCivilizationByName(name);

    }

}
