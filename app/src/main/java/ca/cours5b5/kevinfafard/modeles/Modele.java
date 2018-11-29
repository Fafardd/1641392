package ca.cours5b5.kevinfafard.modeles;

import java.util.Map;

import ca.cours5b5.kevinfafard.exceptions.ErreurSerialisation;


public abstract class Modele {

    public abstract void aPartirObjetJson(Map<String, Object> objetJson) throws ErreurSerialisation;

    public abstract Map<String, Object> enObjetJson();

}
