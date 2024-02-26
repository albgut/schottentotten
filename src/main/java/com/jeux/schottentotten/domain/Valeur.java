package com.jeux.schottentotten.domain;

public enum Valeur {
    UN(1),DEUX(2),TROIS(3),QUATRE(4),CINQ(5),SIX(6),SEPT(7),HUIT(8),NEUF(9);

    Valeur(int intValeur) {
        this.intValeur = intValeur;
    }

    private int intValeur;
}
