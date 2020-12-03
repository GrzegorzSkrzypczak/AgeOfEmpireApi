package pl.grzegorz.ageofempire.empires2.common.service;

public class NoSuchExpansionException extends RuntimeException {
    public NoSuchExpansionException(String expansionName) {
        super(String.format("There is no %s epansion", expansionName));
    }
}
