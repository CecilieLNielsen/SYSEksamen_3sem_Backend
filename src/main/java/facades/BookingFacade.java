/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import DTO.FlightDTO;
import entities.Booking;
import entities.Flight;
import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author rh
 */
public class BookingFacade {

    private static BookingFacade instance;
    private static EntityManagerFactory emf;

    private BookingFacade() {

    }

    public static BookingFacade getFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new BookingFacade();
        }
        return instance;
    }

//    public String makeBooking(Date created, Flight flight, int testPersonID) {
//        EntityManager em = emf.createEntityManager();
//        try {
//            Booking booking = new Booking();
//            int flightid = flight.getFlightId();
//           // flight = FlightFacade.getFacade(emf).getFlightById(flightid);
//            created.toLocalDate(); 
//            booking.setCreated(created);
//            booking.setFlight(flight);
//            em.persist(em);
//        } finally {
//            em.close();
//        }
//
//    }

}
