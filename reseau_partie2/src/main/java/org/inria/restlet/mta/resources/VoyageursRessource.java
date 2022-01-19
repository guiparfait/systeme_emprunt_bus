package org.inria.restlet.mta.resources;

import org.inria.restlet.mta.backend.Backend;
import org.inria.restlet.mta.internals.EtatVoyageur;
import org.inria.restlet.mta.internals.Voyageur;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import java.util.ArrayList;
import java.util.Collection;

public class VoyageursRessource  extends ServerResource {
    /** Backend. */
    private Backend backend_;


    /**
     * Constructor.
     * Call for every single voyageur request.
     */
    public VoyageursRessource()
    {
        super();
        backend_ = (Backend) getApplication().getContext().getAttributes()
                .get("backend");
    }
    /**
     *
     * Returns the list of all the voyageurs
     *
     * @return  JSON representation of the voyageurs
     * @throws JSONException
     */
    @Get("json")
    public Representation getVoyageurs() throws JSONException
    {
        Collection<Voyageur> voyageurs = backend_.getDatabase().getVoyageurs();
        Collection<JSONObject> jsonVoyageurs = new ArrayList<JSONObject>();

        for (Voyageur voyageur : voyageurs)
        {
            JSONObject current = new JSONObject();
            current.put("id", voyageur.getId());
            current.put("name", voyageur.getName());
            current.put("state", voyageur.getState());
            current.put("url", getReference() + "/" + voyageur.getId());
            jsonVoyageurs.add(current);

        }
        JSONArray jsonArray = new JSONArray(jsonVoyageurs);
        return new JsonRepresentation(jsonArray);
    }
    @Post("json")
    public Representation createVoyageur(JsonRepresentation representation)
            throws Exception
    {
        JSONObject object = representation.getJsonObject();
        String name = object.getString("name");
        EtatVoyageur state_ = EtatVoyageur.valueOf(object.getString("state"));


        // Save the Voyageur
        Voyageur voyageur_ = backend_.getDatabase().createVoyageur(name,state_ );

        // generate result
        JSONObject resultObject = new JSONObject();
        resultObject.put("name", voyageur_ .getName());
        resultObject.put("state", voyageur_.getState());
        resultObject.put("id", voyageur_ .getId());
        JsonRepresentation result = new JsonRepresentation(resultObject);
        return result;
    }


}
