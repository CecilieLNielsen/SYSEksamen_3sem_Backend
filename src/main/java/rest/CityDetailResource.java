/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import DTO.CityDetailDTO;
import com.google.gson.Gson;
import java.io.IOException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import utils.HttpUtils;

/**
 * REST Web Service
 *
 * @author abed
 */
@Path("citydetails")
public class CityDetailResource {

    @Context
    private UriInfo context;
    
    Gson gson = new Gson();

    /**
     * Creates a new instance of CityDetailResource
     */
    public CityDetailResource() {
    }
    
    @GET
    @Path("/{WikiDataID}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String cityDetails(@PathParam("WikiDataID") String wikiDataID) throws IOException{
        
        String city = HttpUtils.fetchData("https://wft-geo-db.p.rapidapi.com/v1/geo/cities/" + wikiDataID);
        CityDetailDTO cityDTO = gson.fromJson(city, CityDetailDTO.class);
        
        return gson.toJson(cityDTO);
    }

}
