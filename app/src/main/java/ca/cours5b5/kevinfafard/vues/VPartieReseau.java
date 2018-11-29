package ca.cours5b5.kevinfafard.vues;

import android.content.Context;
import android.util.AttributeSet;

import ca.cours5b5.kevinfafard.R;
import ca.cours5b5.kevinfafard.controleurs.ControleurObservation;
import ca.cours5b5.kevinfafard.controleurs.interfaces.ListenerObservateur;
import ca.cours5b5.kevinfafard.exceptions.ErreurObservation;
import ca.cours5b5.kevinfafard.modeles.MParametresPartie;
import ca.cours5b5.kevinfafard.modeles.MPartie;
import ca.cours5b5.kevinfafard.modeles.MPartieReseau;
import ca.cours5b5.kevinfafard.modeles.Modele;


public class VPartieReseau extends VPartie {


    private VGrille grille;


    public VPartieReseau(Context context) {
        super(context);
    }

    public VPartieReseau(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VPartieReseau(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected String getNomModele(){
        return MPartieReseau.class.getSimpleName();
    }

}
