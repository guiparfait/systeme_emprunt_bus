package org.inria.restlet.mta.resources;

import org.inria.restlet.mta.backend.Backend;
import org.inria.restlet.mta.internals.Bus;
import org.json.JSONArray;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import java.util.ArrayList;
import java.util.Collection;

public class BusRessource extends ServerResource {
    /** Backend.*/
    private Backend backend_;

    /** Bus géré par cette resource.*/
    private Bus bus_;

    /**
     * Constructor.
     * Call for every single bus request.
     */
    public BusRessource()
    {
        backend_ = (Backend) getApplication().getContext().getAttributes()
                .get("backend");
    }


    @Get("json")
    public Representation getBus() throws Exception
    {

        Collection<Bus> bus = backend_.getDatabase().getBus();
        Collection<JSONObject> jsonUsers = new ArrayList<JSONObject>();

        for (Bus bus_ : bus)
        {
            JSONObject current = new JSONObject();
            current.put("id", bus_.get_id());
            current.put("immatriculation", bus_.getImmatriculation());
            current.put("state", bus_.getState());
            current.put("url", getReference() + "/" + bus_.get_id());
            jsonUsers.add(current);

        }
        JSONArray jsonArray = new JSONArray(jsonUsers);
        return new JsonRepresentation(jsonArray);
    }
}
