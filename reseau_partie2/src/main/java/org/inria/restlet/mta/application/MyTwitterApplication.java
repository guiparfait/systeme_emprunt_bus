package org.inria.restlet.mta.application;

import org.inria.restlet.mta.resources.*;
import org.restlet.Application;
import org.restlet.Context;
import org.restlet.Restlet;
import org.restlet.routing.Router;

/**
 *
 * Application.
 *
 * @author msimonin
 *
 */
public class MyTwitterApplication extends Application
{

    public MyTwitterApplication(Context context)
    {
        super(context);
    }

    @Override
    public Restlet createInboundRoot()
    {
        Router router = new Router(getContext());
        router.attach("/bus",BusRessource.class);
        router.attach("/voyageurs", VoyageursRessource.class);
        router.attach("/voyageurs/{voyageurId}", VoyageurRessource.class);
        return router;
    }
}
