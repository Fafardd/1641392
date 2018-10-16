package ca.cours5b5.kevinfafard.controleurs;

import android.util.Log;

import ca.cours5b5.kevinfafard.controleurs.interfaces.Fournisseur;
import ca.cours5b5.kevinfafard.controleurs.interfaces.ListenerFournisseur;

public class Action {
    Fournisseur fournisseur;

    ListenerFournisseur listenerFournisseur;

    Object[] args;

    public void setArguments(Object... args){
        this.args = args;
    }

    public void executerDesQuePossible(){
        Log.d("Atelier07", "Action.executerDesQuePossible");
        ControleurAction.executerDesQuePossible(this);
    }

    Action cloner(){
        Action action = new Action();
        action.fournisseur = fournisseur;
        action.listenerFournisseur = listenerFournisseur;
        action.args = new Object[args.length];

        for(int i =0; i<args.length; i++){
            action.args[i] = args[i];
        }

        return action;
    }
}
