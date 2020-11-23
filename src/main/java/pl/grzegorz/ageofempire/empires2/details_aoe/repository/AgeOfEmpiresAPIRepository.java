package pl.grzegorz.ageofempire.empires2.details_aoe.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class AgeOfEmpiresAPIRepository {

    private final String urlAddress;
    private final RestTemplate restTemplate;



    @Autowired
    public AgeOfEmpiresAPIRepository(@Value("${civilizationcontroller.url}") String urlAddress, RestTemplate restTemplate) {
        this.urlAddress = urlAddress;
        this.restTemplate = restTemplate;
    }

    public AOECivilizationDetailsResponse getCivilizationDetailsResponse (String url) {
       return restTemplate.getForObject(url, AOECivilizationDetailsResponse.class);
    }


}
