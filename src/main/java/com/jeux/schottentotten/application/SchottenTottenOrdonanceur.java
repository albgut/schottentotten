package com.jeux.schottentotten.application;

import com.jeux.schottentotten.adaptateur.PlateauJoueurDTO;
import com.jeux.schottentotten.domain.Partie;
import com.jeux.schottentotten.infrastructure.PartieRepository;
import org.springframework.stereotype.Service;

@Service
public class SchottenTottenOrdonanceur {

    private final PartieRepository partieRepository;

    public SchottenTottenOrdonanceur(PartieRepository partieRepository) {
        this.partieRepository = partieRepository;
    }

    public PlateauJoueurDTO rejoindrePartie(int id, String joueur) {
        Partie partie = partieRepository.findPartieById(id);
        PlateauJoueurDTO plateauJoueurDTO = new PlateauJoueurDTO(partie.getPlateauJoueur1().getMain());
        return plateauJoueurDTO;
    }
}
