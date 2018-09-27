package ca.cours5b5.kevinfafard.vues;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.List;

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

    private List<Colonne> colonnesDeCases;

    private List<VEntete> entetes;

    @Override
    protected void onFinishInflate() {

        super.onFinishInflate();
        creerGrille(6,6);

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
        for(int i=0; i<largeur;i++){
            VEntete vEntete = new VEntete(this.getContext(),i);
            entetes.add(vEntete);
        }

    }
    private void ajouterCases(int hauteur, int largeur){
        for(int i=0; i<hauteur; i++){
            for(int j=0; j<largeur; j++){
                VCase vCase = new VCase(this.getContext(), i,j);
                //colonnesDeCases.add(vCase);
            }
        }
    }

    private LayoutParams getMiseEnPageEntete(int colonne){
        float poidsColonne = 1;
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

        Spec specRangee = GridLayout.spec(rangee, poidsColonne);
        Spec specColonne = GridLayout.spec(colonne, poidsRangee);

        LayoutParams mesParams = new LayoutParams(specRangee,specColonne);

        mesParams.width = 0;
        mesParams.height = 0;
        mesParams.setGravity(Gravity.FILL);

        return mesParams;
    }
}
