/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import DTO.BookingDTO;
import DTO.FlightDTO;
import DTO.MakeBookingDTO;
import entities.Booking;
import entities.Flight;
import entities.Passenger;
import java.sql.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author rh
 */
public class BookingFacade {

    private static BookingFacade instance;
    private static EntityManagerFactory emf;
    private static PassengerFacade pf;
    private static FlightFacade ff;

    private BookingFacade() {

    }

    public static BookingFacade getFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new BookingFacade();
            pf = PassengerFacade.getFacade(emf);
            ff = FlightFacade.getFacade(emf);
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
//
//    public Booking makeBooking(int flightid, String passengerFirstName, String passengerLastName) {
//        EntityManager em = emf.createEntityManager();
//        try {
//            em.getTransaction().begin();
//            PassengerFacade pf = PassengerFacade.getFacade(emf);
//            Booking booking = new Booking();
//            Passenger passengerinfo = pf.getPassengerByName(passengerFirstName, passengerLastName);
//            FlightDTO flightdto = FlightFacade.getFacade(emf).getFlightById(flightid);
//
//            Flight bookedFlight = new Flight();
//            bookedFlight.setFlightId(flightid);
//
//            booking.setFlight(bookedFlight);
//            booking.setPassengerInfo(passengerinfo);
//
//            em.persist(booking);
//
//            em.getTransaction().commit();
//            return booking;
//
//        } finally {
//            em.close();
//        }
//
//   }

    public BookingDTO makeBooking(MakeBookingDTO makeBookingDTO) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Flight flight = ff.getFlightEntityById(makeBookingDTO.getFlightId());
            Passenger passenger = pf.getPassengerById(makeBookingDTO.getUserId());
            Booking booking = new Booking(flight, passenger);
            em.persist(booking);
            em.getTransaction().commit();
            System.out.println(booking.toString());
            return new BookingDTO(booking);
        } finally {
            em.close();
        }

    }

    public Booking getBooking(int id) {
        EntityManager em = emf.createEntityManager();
        try {

            TypedQuery<Booking> query = em.createQuery("SELECT b FROM Booking b WHERE :id = :id", Booking.class).setParameter("id", id);
            return query.getSingleResult();
        } finally {
            em.close();
        }
    }
}


