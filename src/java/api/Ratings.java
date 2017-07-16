/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author ryan
 */
@Path("ratings")
public class Ratings {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Ratings
     */
    public Ratings() {
    }

    /**
     * Retrieves representation of an instance of api.Ratings
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@Context ServletContext context) {
        
        System.out.println(context.getInitParameter("hello"));
        //TODO return proper representation object
        return("{\"Hello\":\"world\"}");
    }

    /**
     * PUT method for updating or creating an instance of Ratings
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
