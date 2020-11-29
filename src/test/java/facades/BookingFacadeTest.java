/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Airport;
import entities.Booking;
import entities.Country;
import entities.Flight;
import entities.Passenger;
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
        List<Airport> airports = new ArrayList();
        Flight f1 = new Flight();
        Airport airport = new Airport();
        Airport airport2 = new Airport();
        airport.setAirportName("Spain airport");
        airport2.setAirportName("France airport");
        f1.setFlightId(1);
        airports.add(airport);
        airports.add(airport2);
        Country country = new Country("Spain", airports);
        f1.setDestinationAirport(airport);
        f1.setTakeoffAirport(airport2);
        country.setAirports(airports);
        System.out.println(f1.getFlightId());
        System.out.println(f1.getDestinationAirport().getAirportName());
        airport.setCountry(country);

        try {

            em.getTransaction().begin();
            em.createQuery("delete from Country").executeUpdate();
            em.createQuery("delete from Airport").executeUpdate();
            em.createQuery("delete from Flight").executeUpdate();

            em.persist(country);
            em.persist(f1);
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
//        Booking book = new Booking();
//        Passenger testPassenger = new Passenger("Peter", "Pertersen", "peter@email.dk", 123456789);
//        book = facade.makeBooking(1, testPassenger);
//        assertEquals(1, book.getFlight().getFlightId());
//    }

}
