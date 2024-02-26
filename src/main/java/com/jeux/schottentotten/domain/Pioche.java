package com.jeux.schottentotten.domain;

import java.util.*;
import java.util.stream.IntStream;

public class Pioche {

    private List<Carte> cartes;

    private Pioche(){}

    public static Pioche construire() {
        Pioche pioche = new Pioche();
        pioche.cartes = preparerCartes();
        Collections.shuffle(pioche.cartes);
        return pioche;
    }

    private static ArrayList<Carte> preparerCartes() {
        return new ArrayList<>(Arrays.stream(Couleur.values())
                .flatMap(couleur -> Arrays.stream(Valeur.values())
                        .map(valeur -> new Carte(couleur, valeur)))
                .toList());
    }

    public List<Carte> piocherMain() {
        return IntStream.range(0, 6).mapToObj(x -> pioche()).toList();
    }

    private Carte pioche() {
        Carte carte = cartes.get(0);
        cartes.remove(carte);
        return carte;
    }
}
