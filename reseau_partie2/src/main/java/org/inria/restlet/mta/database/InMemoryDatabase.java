package org.inria.restlet.mta.database;

import java.util.*;

import org.inria.restlet.mta.internals.*;

/**
 *
 * In-memory database
 *
 * @author ctedeschi
 * @author msimonin
 *
 */
public class InMemoryDatabase
{


    /** Bus count (next id to give).*/
    private int  busCount_;
    /** bus Hashmap. */
    Map<Integer, Bus> bus_;
    /** Voyageur count (next id to give).*/
    private int voyageCount_;
    /** Voyageur Hashmap. */
    Map<Integer, Voyageur> voyageur_;



    public InMemoryDatabase()
    {
        voyageur_ = new HashMap<Integer, Voyageur>();
        bus_ = new HashMap<Integer, Bus>();
    }



    /**
     *
     * Synchronized voyageur creation.
     * @param name
     * @param state
     *
     * @return the voyageur created
     */
    public synchronized Voyageur createVoyageur(String name, EtatVoyageur state){
         Voyageur voyageur = new Voyageur(name,state);
         voyageur.setId(voyageCount_);
         voyageur_.put(voyageCount_, voyageur);
         voyageCount_++;
         return voyageur;
    }
    public Collection<Voyageur> getVoyageurs(){return voyageur_.values();}

    public Voyageur getVoyageur(int id){
        return voyageur_.get(id);
    }
    /**
     *
     * Synchronized bus creation.
     * @param immatriculation
     * @param etatBus
     *
     * @return the user created
     */

    public synchronized Bus createBus(String immatriculation,EtatBus etatBus){
        Bus bus = new Bus(immatriculation,etatBus);
        bus.set_id(busCount_);
        bus_.put(busCount_,bus);
        busCount_++;
        return bus;

    }
    public Collection<Bus> getBus(){return bus_.values();}

    public Voyageur getBus(int id){
        return voyageur_.get(id);
    }


}
