/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import facades.FlightFacade;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import utils.EMF_Creator;

/**
 * REST Web Service
 *
 * @author rh
 */
@Path("flight")
public class FlightResource {
    
    
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final FlightFacade facade = FlightFacade.getFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of FlightResource
     */
    public FlightResource() {
    }

    /**
     * Retrieves representation of an instance of rest.FlightResource
     * @return an instance of java.lang.String
     */
    
    //returns all flights in database. 
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
       return GSON.toJson(facade.getAllFligths());
    }

    /**
     * PUT method for updating or creating an instance of FlightResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
