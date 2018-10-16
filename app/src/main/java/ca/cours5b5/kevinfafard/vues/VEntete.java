package ca.cours5b5.kevinfafard.vues;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

public class VEntete extends AppCompatButton {
    public VEntete(Context context) {
        super(context);
    }

    public VEntete(Context context, AttributeSet attrs){
        super(context, attrs);

    }

    public VEntete(Context context, AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);

    }

    public VEntete(Context context, int colonne){
        super(context);
        setText(String.valueOf(colonne) + "\n" + "\u2193");

    }
}
