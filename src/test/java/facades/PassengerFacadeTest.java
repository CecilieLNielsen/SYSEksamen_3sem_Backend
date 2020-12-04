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
public class PassengerFacadeTest {

    private static EntityManagerFactory emf;
    private static PassengerFacade facade;

    private Passenger p1, p2;

    @BeforeAll
    public static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactoryForTest();
        facade = PassengerFacade.getFacade(emf);
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

        try {
            p1 = new Passenger();
            p2 = new Passenger();
            p1.setEmail("testPass@email.com");
            p1.setFirstName("Peter");
            p1.setLastName("Petersen");
            p1.setPhoneNumber(12345678);
            
            p2.setEmail("p2@email.com");
            p2.setFirstName("Rasmus");
            p2.setLastName("Rasmussen");
            p2.setPhoneNumber(87654321);

            em.getTransaction().begin();
            em.persist(p1);
            
            em.getTransaction().commit();

        } finally {
            em.close();
        }
    }

    @AfterEach
    public void tearDown() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.createQuery("delete from Passenger").executeUpdate();

        em.getTransaction().commit();
        em.close();
    }


    @Test
    public void testGetByName() {
        Passenger pass = facade.getPassengerByName("Peter", "Petersen");
        assertEquals("Peter", pass.getFirstName());
    }
    

}
