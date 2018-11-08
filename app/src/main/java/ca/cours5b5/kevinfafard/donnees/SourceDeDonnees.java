package ca.cours5b5.kevinfafard.donnees;

import java.util.Map;


public abstract class SourceDeDonnees {

    public abstract void chargerModele(final String cheminSauvegarde, final ListenerChargement listenerChargement);

    public abstract void sauvegarderModele(final String cheminSauvegarde, final Map<String, Object> objetJson);

    //public abstract void detruireSauvegarde(String cheminSauvegarde);

    protected String getNomModele(String cheminSauvegarde){

        String[] split = cheminSauvegarde.split("/");
        return split[0];
    }

}
