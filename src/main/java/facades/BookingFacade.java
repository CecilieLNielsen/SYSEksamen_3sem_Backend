/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import DTO.FlightDTO;
import entities.Booking;
import entities.Flight;
import entities.Passenger;
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

    public Booking makeBooking(int flightid, Passenger testPerson) {
        
        
        EntityManager em = emf.createEntityManager();
        try {

            Booking booking = new Booking();
            Date created = new Date(0, 0, 0);
            
            FlightDTO flightdto = FlightFacade.getFacade(emf).getFlightById(flightid);
            System.out.println(flightdto);
            created.toInstant();
            Flight bookedFlight = new Flight();
            bookedFlight.setFlightId(flightdto.getFlightId());
            
            System.out.println(created);
            booking.setCreated(created);
            booking.setFlight(bookedFlight);
            booking.setPassengerInfo(testPerson);
            em.persist(booking);

            return booking;
        } finally {
            em.close();
        }

    }
    
    
    
    



}
