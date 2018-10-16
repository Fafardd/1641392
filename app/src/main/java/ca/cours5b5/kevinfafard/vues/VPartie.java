package ca.cours5b5.kevinfafard.vues;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;

import ca.cours5b5.kevinfafard.R;
import ca.cours5b5.kevinfafard.controleurs.ControleurObservation;
import ca.cours5b5.kevinfafard.controleurs.interfaces.ListenerObservateur;
import ca.cours5b5.kevinfafard.modeles.MParametres;
import ca.cours5b5.kevinfafard.modeles.MPartie;
import ca.cours5b5.kevinfafard.modeles.Modele;

public class VPartie extends Vue{

    private VGrille grille;

    public VPartie(Context context) {
        super(context);
    }
    public VPartie(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VPartie(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {

        super.onFinishInflate();
        Log.d("Atelier06", "VPartie::OnFinishInflate");
        initialiser();
        observerPartie();
    }

    private void initialiser(){
        grille = this.findViewById(R.id.VGrille);
    }

    private void observerPartie(){
        Log.d("Atelier06", "VPartie::ObserverPartie");
        //MPartie partie = new MPartie(MParametres.instance.parametresPartie);
        String name = MPartie.class.getSimpleName();

        ControleurObservation.observerModele(name, new ListenerObservateur() {
            @Override
            public void reagirChangementAuModele(Modele modele) {
                Log.d("Atelier07", "VPartie.reagirChangementAuModele");
                afficherParametres((MPartie) modele);
                miseAJourGrille((MPartie) modele);
            }
            @Override
            public void reagirNouveauModele(Modele modele) {
                Log.d("Atelier06", "VPartie::reagirNouveauModele");
                super.reagirNouveauModele(modele);
                MPartie partie = (MPartie) modele;

                initialiserGrille(partie);
            }
        });
    }
    private void afficherParametres(MPartie partie){

    }
    private MPartie getPartie(Modele modele){

        return null;
    }

    private void initialiserGrille(MPartie mPartie){
        int hauteur = mPartie.getParametres().getHauteur();
        int largeur = mPartie.getParametres().getLargeur();
        grille.creerGrille(hauteur,largeur);
    }

    public void miseAJourGrille(MPartie partie){
        grille.afficherJetons(partie.getGrille());
    }
}
