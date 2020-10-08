package pl.grzegorz.ageofempire.empires2.repository;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class AgeOfEmpiresRepository {

    private final String urlAddress;
    private final RestTemplate restTemplate;

    public AgeOfEmpiresRepository(@Value("${aoeapi.url.address}")String urlAddress, RestTemplate restTemplate) {
        this.urlAddress = urlAddress;
        this.restTemplate = restTemplate;
    }

    public CivilisationRepositoryResponse getCivilizations() {
        return restTemplate.getForObject(urlAddress, CivilisationRepositoryResponse.class);
    }



}
