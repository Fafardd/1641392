package ca.cours5b5.kevinfafard.vues;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.List;

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
        }


    }
    private void ajouterCases(int hauteur, int largeur){
        lesCases = new VCase[hauteur][largeur];
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
}
