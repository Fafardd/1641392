package ca.cours5b5.kevinfafard.vues;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.List;

import ca.cours5b5.kevinfafard.controleurs.Action;
import ca.cours5b5.kevinfafard.controleurs.ControleurAction;
import ca.cours5b5.kevinfafard.global.GCommande;
import ca.cours5b5.kevinfafard.global.GCouleur;
import ca.cours5b5.kevinfafard.modeles.MColonne;
import ca.cours5b5.kevinfafard.modeles.MGrille;
import ca.cours5b5.kevinfafard.modeles.MParametres;

public class VGrille extends GridLayout{
    public VGrille(Context context) {
        super(context);
    }

    public VGrille(Context context, AttributeSet attrs){
        super(context, attrs);

    }

    public VGrille(Context context, AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);

    }

    private int nombreRangees;

    private class Colonne extends ArrayList<VCase>{

    };

    //private List<Colonne> colonnesDeCases = new ArrayList<>();

    private List<VEntete> entetes;

    private VCase[][] lesCases;

    private Action actionEnTete;

    @Override
    protected void onFinishInflate() {

        Log.d("test11", "fdfdsafds");
        super.onFinishInflate();
        //creerGrille(MParametres.instance.parametresPartie.hauteur,MParametres.instance.parametresPartie.largeur);
        /*ajouterEnTetes(6);
        ajouterCases(6,6);*/

    }

    private void initialiser(){

    }

    void creerGrille(int hauteur, int largeur){
        ajouterEnTetes(largeur);
        ajouterCases(hauteur,largeur);
    }

    private void initialiserColonnes(int largeur){

    }

    private void ajouterEnTetes(int largeur){
        entetes = new ArrayList<>();
        for(int i=0; i<largeur;i++){
            Log.d("test11", "1");
            VEntete vEntete = new VEntete(this.getContext(),i);
            Log.d("test11", "2");
            entetes.add(vEntete);
            Log.d("test11", "3");
            addView(vEntete, getMiseEnPageEntete(i));
            Log.d("test11", "4");
            //Pour chaque en-tete, on veut installer le listener
            installerListenerEntete(vEntete, i);
        }

        demanderActionEntete();


    }
    private void ajouterCases(int hauteur, int largeur){
        initialiserTableauDeCases(hauteur, largeur);
        for(int i=0; i<hauteur; i++){
            for(int j=0; j<largeur; j++){
                //Log.d("test11", "1");
                VCase vCase = new VCase(this.getContext(), i,j);
                //Log.d("test11", "2");
                lesCases[i][j] = vCase;
                //colonnesDeCases.add(vCase);
                addView(vCase, getMiseEnPageCase(hauteur - i,j));
            }
        }
    }

    private LayoutParams getMiseEnPageEntete(int colonne){
        float poidsColonne = 3;
        float poidsRangee = 1;

        int rangee=0;

        Spec specRangee = GridLayout.spec(rangee, poidsColonne);
        Spec specColonne = GridLayout.spec(colonne, poidsRangee);

        LayoutParams mesParams = new LayoutParams(specRangee,specColonne);

        mesParams.width = 0;
        mesParams.height = 0;
        mesParams.setGravity(Gravity.FILL);

        return mesParams;
    }



    private LayoutParams getMiseEnPageCase(int rangee, int colonne){
        float poidsColonne = 1;
        float poidsRangee = 1;

        Spec specRangee = GridLayout.spec(rangee +1, poidsColonne);
        Spec specColonne = GridLayout.spec(colonne, poidsRangee);

        LayoutParams mesParams = new LayoutParams(specRangee,specColonne);

        mesParams.width = 0;
        mesParams.height = 0;
        mesParams.setGravity(Gravity.FILL);

        return mesParams;
    }

    private void initialiserTableauDeCases(int hauteur, int largeur){
        lesCases = new VCase[hauteur][largeur];
    }

    private void demanderActionEntete(){
            actionEnTete = ControleurAction.demanderAction(GCommande.JOUER_COUP_ICI);
    }

    private void installerListenerEntete(VEntete entete, final int colonne){
        entete.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                actionEnTete.setArguments(colonne);
                actionEnTete.executerDesQuePossible();
            }
        });

    }

    void afficherJetons(MGrille grille){
        List<MColonne> listeColonne = grille.getColonnes();

        for(int colonne=0;colonne<listeColonne.size();++colonne){

            MColonne colonneActuel = listeColonne.get(colonne);

            for(int rangee=0;rangee<colonneActuel.getJetons().size();++rangee){
                afficherJeton(colonne,rangee,colonneActuel.getJetons().get(rangee));

            }
        }

    }

    private void afficherJeton(int colonne, int rangee, GCouleur jeton){
        lesCases[rangee][colonne].afficherJeton(jeton);
    }
}
