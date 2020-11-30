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

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Booking makeBooking(int flightid, String passengerFirstName, String passengerLastName) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            PassengerFacade pf = PassengerFacade.getFacade(emf);
            Booking booking = new Booking();
            Passenger passengerinfo = pf.getPassengerByName(passengerFirstName, passengerLastName);
            FlightDTO flightdto = FlightFacade.getFacade(emf).getFlightById(flightid);

            Flight bookedFlight = new Flight();
            bookedFlight.setFlightId(flightid);

            booking.setFlight(bookedFlight);
            booking.setPassengerInfo(passengerinfo);

            em.persist(booking);

            em.getTransaction().commit();
            return booking;

        } finally {
            em.close();
        }

    }



}
