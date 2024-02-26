package com.jeux.schottentotten.adaptateur;

import com.jeux.schottentotten.application.SchottenTottenOrdonanceur;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class SchottenTottenController {

    private final SchottenTottenOrdonanceur ordonanceur;

    public SchottenTottenController(SchottenTottenOrdonanceur ordonanceur) {
        this.ordonanceur = ordonanceur;
    }

    @PostMapping("/demarrerPartie")
    public ResponseEntity<PartieDTO> demarrerPartie(){
        return ResponseEntity.created(URI.create(("/demarrerPartie/1")))
                .body(new PartieDTO(1));
    }

    @PutMapping("/rejoindrePartie/{id}")
    public ResponseEntity<PlateauJoueurDTO> rejoindrePartie(@PathVariable int id, @RequestParam(name = "joueur") String joueur){
        PlateauJoueurDTO plateauJoueur = ordonanceur.rejoindrePartie(id, joueur);
        return ResponseEntity.ok(plateauJoueur);
    }
}
