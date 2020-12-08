/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import DTO.MakeBookingDTO;
import entities.Airport;
import entities.Booking;
import entities.Country;
import entities.Flight;
import entities.Passenger;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.EMF_Creator;

/**
 *
 * @author rh
 */
public class BookingFacadeTest {

    private static EntityManagerFactory emf;
    private static BookingFacade facade;

    private Flight flight;

    @BeforeAll
    public static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactoryForTest();
        facade = BookingFacade.getFacade(emf);
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

    }

    @AfterAll
    public static void tearDownClass() {
//        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }

    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createQuery("delete from Country").executeUpdate();
            em.createQuery("delete from Airport").executeUpdate();
            em.createQuery("delete from Flight").executeUpdate();

            List<Airport> airports = new ArrayList();
            Flight flight = new Flight(new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), 4324);
            Airport airport = new Airport();
            Airport airport2 = new Airport();
            Passenger testPassenger = new Passenger(1, "Peter", "Pertersen", "peter@email.dk", 123456789);
            airport.setAirportName("Spain airport");
            airport2.setAirportName("France airport");

            airports.add(airport);
            airports.add(airport2);

            Country country = new Country("Spain", airports);

            flight.setDestinationAirport(airport);
            flight.setTakeoffAirport(airport2);
            country.setAirports(airports);

            airport.setCountry(country);
            
            em.persist(country);
            em.persist(flight);
            em.persist(testPassenger);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @AfterEach
    public void tearDown() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.getTransaction().commit();
    }

//    @Test
//    public void testMakeBooking() {
//        Passenger testPassenger = new Passenger(1, "Peter", "Pertersen", "peter@email.dk", 123456789);
//        
//        
//        MakeBookingDTO book = new MakeBookingDTO(1, flight.getFlightId(), testPassenger.getId());
//        
//        facade.makeBooking(book);
//        Booking result = facade.getBooking(book.getId());
//        assertEquals(1, result.getId());
//
//    }

}
