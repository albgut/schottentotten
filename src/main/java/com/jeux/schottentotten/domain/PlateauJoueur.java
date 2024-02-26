package com.jeux.schottentotten.domain;

import java.util.List;

public class PlateauJoueur {
    private List<Carte> main;

    private String nom;

    public PlateauJoueur(List<Carte> main) {
        this.main = main;
    }

    public List<Carte> getMain() {
        return main;
    }
}
