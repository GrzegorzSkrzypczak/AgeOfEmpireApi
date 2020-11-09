package pl.grzegorz.ageofempire.empires2.app_loader.repository;


public class CivilisationResult {

    private int id;
    private String name;
    //TODO załączyć adres url do proprtries
    private String url = "https://age-of-empires-2-api.herokuapp.com/api/v1/civilization/";


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url + id;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
