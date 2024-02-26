package com.jeux.schottentotten.domain;

import com.jeux.schottentotten.adaptateur.PlateauJoueurDTO;

import java.io.File;
import java.util.List;
import java.util.Stack;

public class Partie {

    private static Partie partie;
    private int id;

    private Pioche pioche;

    private PlateauJoueur plateauJoueur1;

    private PlateauJoueur plateauJoueur2;

    private Partie(int id){
        this.id = id;
    }

    public static Partie buildPartie(){
        Partie partie  = new Partie(1);
        partie.pioche = Pioche.construire();
        List<Carte> mainJoueur1 = partie.pioche.piocherMain();
        List<Carte> mainJoueur2 = partie.pioche.piocherMain();
        partie.plateauJoueur1 = new PlateauJoueur(mainJoueur1);
        partie.plateauJoueur2 = new PlateauJoueur(mainJoueur2);
        return partie;
    }

    public PlateauJoueur getPlateauJoueur1() {
        return plateauJoueur1;
    }

    public PlateauJoueur getPlateauJoueur2() {
        return plateauJoueur2;
    }
}
