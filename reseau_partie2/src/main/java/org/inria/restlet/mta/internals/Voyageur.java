package org.inria.restlet.mta.internals;

public class Voyageur {
    private int id;
    private  String name;
    /* L'etat d'un voyageur */
    private EtatVoyageur state;

    public Voyageur(String name, EtatVoyageur state) {
        this.name = name;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public EtatVoyageur getState() {
        return state;
    }

    public void setId(int id) {
        this.id = id;
    }
}
