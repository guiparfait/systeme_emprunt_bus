package org.inria.restlet.mta.internals;

public class Bus {
    private int _id;
    private String immatriculation;
    private EtatBus state;

    public Bus(String immatriculation, EtatBus state) {
        this.immatriculation = immatriculation;
        this.state = state;
    }

    public int get_id() {
        return _id;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public EtatBus getState() {
        return state;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void setState(EtatBus state) {
        this.state = state;
    }
}
