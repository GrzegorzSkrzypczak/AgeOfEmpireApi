package pl.grzegorz.ageofempire.empires2.common.web;

import org.springframework.web.bind.annotation.*;
import pl.grzegorz.ageofempire.empires2.details_aoe.repository.CivilizationDetails;
import pl.grzegorz.ageofempire.empires2.details_aoe.service.CivilizationDetailsService;
import java.util.List;

@RequestMapping("/civilization")
@RestController
public class CivilizationcontrollerDetails {

//        private final CivilizationDetailsService civilizationDetailsService;
//
//        public CivilizationcontrollerDetails(CivilizationDetailsService civilizationDetailsService) {
//            this.civilizationDetailsService = civilizationDetailsService;
//        }
//
//        @GetMapping("/{name}")
//        @CrossOrigin
//        public CivilizationDetails getCivilizationDetails(@PathVariable String name) {
//            return civilizationDetailsService.getCivilizationDetails(name);
//        }
//
//        @GetMapping
//        @CrossOrigin
//        public List<CivilizationDetails> getCivilizations(@RequestParam List<String> civilizationNames) {
//            return civilizationDetailsService.getCivilizationDetailsList(civilizationNames);
//        }

}
