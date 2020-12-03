package pl.grzegorz.ageofempire.empires2.common.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.grzegorz.ageofempire.empires2.common.repository.Civilization;
import pl.grzegorz.ageofempire.empires2.app_loader.service.CivilizationService;
import pl.grzegorz.ageofempire.empires2.details_aoe.repository.CivilizationDetails;
import pl.grzegorz.ageofempire.empires2.details_aoe.service.CivilizationDetailsService;

import java.util.List;

@RequestMapping("/civilizations")
@RestController
public class CivilizationController {

    private final CivilizationService civilizationService;
    private final CivilizationDetailsService civilizationDetailsService;

    @Autowired
    public CivilizationController(CivilizationService civilizationService, CivilizationDetailsService civilizationDetailsService) {
        this.civilizationService = civilizationService;
        this.civilizationDetailsService = civilizationDetailsService;
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

    @GetMapping("civilizationDetails")
    @CrossOrigin
    public CivilizationDetails getCivilizationDetails(String details) {
        return civilizationDetailsService.getCivilizationDetails(details);
    }

    @GetMapping("CivilizationDetailsList")
    @CrossOrigin
    public List<CivilizationDetails> getCivilizations(@RequestParam List<String> civilizationNames) {
        return civilizationDetailsService.getCivilizationDetailsList(civilizationNames);
    }

    @GetMapping("expansionSearch")
    @CrossOrigin
    public CivilizationDetails getCivilizationDetailsByExpansion(String expansion){
        return civilizationDetailsService.getCivilizationDetailsByExpansion(expansion);
    }

}
