package pl.grzegorz.ageofempire.empires2.details_aoe.repository.aoeapi;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class ApiCivilizationDetailsRepository {

    private final RestTemplate restTemplate;

    public ApiCivilizationDetailsRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CivilizationDetailsResponse getCivilizationDetailsResponse(String url){
        return restTemplate.getForObject(url,CivilizationDetailsResponse.class);
    }


}
