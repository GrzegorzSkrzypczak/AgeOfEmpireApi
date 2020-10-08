package pl.grzegorz.ageofempire.empires2.common.service;

public class NoSuchCivilizationExeption extends RuntimeException {

    public NoSuchCivilizationExeption(String civilisationName) {
        super(String.format("No civilisation %s found", civilisationName));
    }
}
