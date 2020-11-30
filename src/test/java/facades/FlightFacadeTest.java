/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import DTO.FlightDTO;
import entities.Airport;
import entities.Country;
import entities.Flight;
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
public class FlightFacadeTest {

    private static EntityManagerFactory emf;
    private static FlightFacade facade;

    private Flight f1;

    @BeforeAll
    public static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactoryForTest();
        facade = FlightFacade.getFacade(emf);
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

    }

    @AfterAll
    public static void tearDownClass() {
//        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }

    // Setup the DataBase in a known state BEFORE EACH TEST
    //TODO -- Make sure to change the code below to use YOUR OWN entity class
    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        List<Airport> airports = new ArrayList();
        Flight f1 = new Flight();
        Airport airport = new Airport();
        Airport airport2 = new Airport();
        airport.setAirportName("Spain airport");
        airport2.setAirportName("France airport");

        airports.add(airport);
        airports.add(airport2);
        Country country = new Country("Spain", airports);
        f1.setDestinationAirport(airport);
        f1.setTakeoffAirport(airport2);
        f1.setFlightId(1);
        country.setAirports(airports);
        System.out.println(f1.getFlightId());
        System.out.println(f1.getDestinationAirport().getAirportName());
        airport.setCountry(country);

        try {

            em.getTransaction().begin();

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
        em.createQuery("delete from Flight").executeUpdate();
        em.createQuery("delete from Airport").executeUpdate();
        em.createQuery("delete from Country").executeUpdate();

        em.getTransaction().commit();
        em.close();
    }

    @Test
    public void testGetById() {

        int id = 1;
        FlightDTO flightdto = facade.getFlightById(id);
        System.out.println(flightdto.getFlightId());
        assertEquals("Spain airport", flightdto.getDestinationAirport());
    }

    @Test
    public void testGetAll() {
        List<FlightDTO> result = facade.getAllFligths();
        assertEquals(1, result.size());
    }

}
