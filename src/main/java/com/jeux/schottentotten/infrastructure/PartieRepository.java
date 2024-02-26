package com.jeux.schottentotten.infrastructure;

import com.jeux.schottentotten.domain.Partie;
import org.springframework.stereotype.Repository;

@Repository
public class PartieRepository {
    public Partie findPartieById(int id){
        return Partie.buildPartie();
    }
}
