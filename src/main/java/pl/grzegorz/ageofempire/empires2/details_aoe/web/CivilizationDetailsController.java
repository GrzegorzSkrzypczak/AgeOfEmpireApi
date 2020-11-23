package pl.grzegorz.ageofempire.empires2.details_aoe.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.grzegorz.ageofempire.empires2.details_aoe.repository.AOECivilizationDetails;
import pl.grzegorz.ageofempire.empires2.details_aoe.service.AOECivilizationDetailsService;

@RequestMapping("/civilization")
@RestController
public class CivilizationDetailsController {

    private final AOECivilizationDetailsService aoeCivilizationDetailsService;

    @Autowired
    public CivilizationDetailsController(AOECivilizationDetailsService aoeCivilizationDetailsRepository) {
        this.aoeCivilizationDetailsService = aoeCivilizationDetailsRepository;
    }


    @GetMapping("/{id}")
    @CrossOrigin
    public AOECivilizationDetails getById(@PathVariable int id) {
        //TODO zrobic respone iResttemplate zeby dzialolo jak w pokemon api
        return aoeCivilizationDetailsService.getCivilizationDetailsById(id);

    }
}
