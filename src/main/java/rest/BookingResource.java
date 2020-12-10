/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import DTO.MakeBookingDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.Booking;
import entities.Passenger;
import facades.BookingFacade;
import javax.persistence.EntityManagerFactory;
import javax.validation.Valid;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import utils.EMF_Creator;

/**
 * REST Web Service
 *
 * @author rh
 */
@Path("booking")
public class BookingResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final BookingFacade facade = BookingFacade.getFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of BookingResource
     */
    public BookingResource() {
    }

    /**
     * Retrieves representation of an instance of rest.BookingResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for creating an booking
     *
     * @param booking json string
     * @return String msg
     */
    @POST
    @Path("/book")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String makeBooking(String booking) {
        MakeBookingDTO bookingDTO = GSON.fromJson(booking, MakeBookingDTO.class);
        System.out.println(bookingDTO.toString());
        System.out.println(facade.makeBooking(bookingDTO).toString());
        return GSON.toJson(facade.makeBooking(bookingDTO));
    }

    @GET
    @Path("/id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getFlightById(@PathParam("id") int id) {
        return GSON.toJson(facade.getBooking(id));
    }
    
}
