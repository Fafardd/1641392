package ca.cours5b5.kevinfafard.modeles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.cours5b5.kevinfafard.exceptions.ErreurSerialisation;
import ca.cours5b5.kevinfafard.global.GCouleur;
import ca.cours5b5.kevinfafard.serialisation.AttributSerialisable;

public class MColonne extends Modele {

    private List<MJeton> jetons;

    public MColonne(){

        jetons = new ArrayList<>();

    }


    public List<MJeton> getJetons() {
        return jetons;
    }


    public void placerJeton(GCouleur couleur) {

        jetons.add(new MJeton(couleur));

    }


    @Override
    public void aPartirObjetJson(Map<String, Object> objetJson) throws ErreurSerialisation {

        throw new UnsupportedOperationException();

    }


    @Override
    public Map<String, Object> enObjetJson() throws ErreurSerialisation {

        throw new UnsupportedOperationException();
        
    }


}
