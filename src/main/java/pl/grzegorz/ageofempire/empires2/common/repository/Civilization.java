package pl.grzegorz.ageofempire.empires2.common.repository;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Civilization {


    private int id;
    @Id
    private String name;
    private String url;

    public Civilization() {
    }

    public Civilization(int id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }

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
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
