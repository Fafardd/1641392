package ca.cours5b5.kevinfafard.controleurs;

import java.util.Map;

import ca.cours5b5.kevinfafard.controleurs.interfaces.ListenerObservateur;
import ca.cours5b5.kevinfafard.modeles.MPartie;
import ca.cours5b5.kevinfafard.modeles.Modele;

public class ControleurObservation {

    private static Map<Modele, ListenerObservateur> observations;

    private static MPartie partie;

    static {

    }

    public static void observerModele(String nomModele, final ListenerObservateur listenerObservateur){



    }
}
