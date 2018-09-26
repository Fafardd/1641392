package ca.cours5b5.kevinfafard.vues;
import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import ca.cours5b5.kevinfafard.R;
import ca.cours5b5.kevinfafard.activites.AMenuPrincipal;
import ca.cours5b5.kevinfafard.activites.AParametres;


public class VMenuPrincipal extends Vue{

    static {
        Log.d("Atelier04", VMenuPrincipal.class.getSimpleName() + ":: static");
    }
    public VMenuPrincipal(Context context){
        super(context);
    }

    public VMenuPrincipal(Context context, AttributeSet attrs){
        super(context, attrs);
    }
    public VMenuPrincipal(Context context, AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        Log.d("Atelier04", this.getClass().getSimpleName() + ":: onFinishInflate");
        Button boutonParametres = this.findViewById(R.id.bouton_parametres);



        boutonParametres.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

            }
        });
    }
}
