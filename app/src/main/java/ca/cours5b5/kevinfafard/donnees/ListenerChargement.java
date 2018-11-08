package ca.cours5b5.kevinfafard.donnees;

import java.util.Map;

public interface ListenerChargement {


    void reagirSucces(Map<String, Object> objectJson);

    void reagirErreur(Exception e);
}
