package org.inria.restlet.mta.resources;

import org.inria.restlet.mta.backend.Backend;
import org.inria.restlet.mta.internals.Voyageur;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class VoyageurRessource extends ServerResource {
    /** Backend.*/
    private Backend backend_;

    /** Voyageur géré par cette resource.*/
    private Voyageur voyageur_;

    /**
     * Constructor.
     * Call for every single voyageur request.
     */
    public VoyageurRessource()
    {
        backend_ = (Backend) getApplication().getContext().getAttributes()
                .get("backend");
    }


    @Get("json")
    public Representation getVoyageur() throws Exception
    {
        //
        String voyageurIdString = (String) getRequest().getAttributes().get("voyageurId");
        int voyageurId = Integer.valueOf(voyageurIdString);
        voyageur_ = backend_.getDatabase().getVoyageur(voyageurId);

        JSONObject userObject = new JSONObject();
        userObject.put("name", voyageur_.getName());
        userObject.put("state", voyageur_.getState());
        userObject.put("id", voyageur_.getId());
        return new JsonRepresentation(userObject);
    }
}
