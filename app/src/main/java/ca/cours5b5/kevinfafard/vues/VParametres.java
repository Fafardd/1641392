package ca.cours5b5.kevinfafard.vues;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;


import ca.cours5b5.kevinfafard.R;
import ca.cours5b5.kevinfafard.global.GConstantes;
import ca.cours5b5.kevinfafard.modeles.MParametres;

public class VParametres extends Vue{{}

    static {
        Log.d("Atelier04", VParametres.class.getSimpleName() + " :: static");
    }
    public VParametres(Context context){
        super(context);
    }

    public VParametres(Context context, AttributeSet attrs){
        super(context, attrs);
    }
    public VParametres(Context context, AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        Log.d("Atelier04", this.getClass().getSimpleName() + ":: onFinishInflate");
        super.onFinishInflate();
        Log.d("kevintest","valeur2");
        Spinner hauteurSpinner = this.findViewById(R.id.hauteurSpinner);
        Spinner largeurSpinner = this.findViewById(R.id.largeurSpinner);
        Spinner pourGagnerSpinner = this.findViewById(R.id.pourGagnerSpinner);

        TextView hauteur = this.findViewById(R.id.hauteur);
        TextView largeur = this.findViewById(R.id.largeur);
        TextView pourGagner = this.findViewById(R.id.pourGagner);


        ArrayAdapter<Integer> adapterHauteur = new ArrayAdapter<>(this.getContext(), R.layout.support_simple_spinner_dropdown_item);
        hauteurSpinner.setAdapter(adapterHauteur);
        /*for(int i = GConstantes.hauteurMin; i<=GConstantes.hauteurMax; i++){
            adapterHauteur.add(i);
        }*/

        adapterHauteur.addAll(MParametres.instance.getChoixHauteur());

        hauteurSpinner.setSelection(adapterHauteur.getPosition(MParametres.instance.parametresPartie.hauteur));


        ArrayAdapter<Integer> adapterLargeur = new ArrayAdapter<>(this.getContext(), R.layout.support_simple_spinner_dropdown_item);
        largeurSpinner.setAdapter(adapterLargeur);
        /*for(int i=GConstantes.largeurMin; i<=GConstantes.hauteurMax;i++){
            adapterLargeur.add(i);
        }*/

        adapterLargeur.addAll(MParametres.instance.getChoixHauteur());

        largeurSpinner.setSelection(adapterLargeur.getPosition(MParametres.instance.parametresPartie.largeur));

        ArrayAdapter<Integer> adapterPourGagner = new ArrayAdapter<>(this.getContext(), R.layout.support_simple_spinner_dropdown_item);
        pourGagnerSpinner.setAdapter(adapterPourGagner);
        /*for(int i=GConstantes.pourGagnerMin; i<=GConstantes.pourGagnerMax;i++){
            adapterPourGagner.add(i);
        }*/

        adapterPourGagner.addAll(MParametres.instance.getChoixHauteur());

        pourGagnerSpinner.setSelection(adapterPourGagner.getPosition(MParametres.instance.parametresPartie.pourGagner));



        hauteurSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Integer choix = (Integer) adapterView.getAdapter().getItem(i);
                MParametres.instance.parametresPartie.setHauteur(choix);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        largeurSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Integer choix = (Integer) adapterView.getAdapter().getItem(i);
                MParametres.instance.parametresPartie.setLargeur(choix);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        pourGagnerSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Integer choix = (Integer) adapterView.getAdapter().getItem(i);
                MParametres.instance.parametresPartie.setPourGagner(choix);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



    }
}
