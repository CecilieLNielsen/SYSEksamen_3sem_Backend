package utils;

import entities.Airport;
import entities.Country;
import entities.Flight;
import entities.Role;
import entities.User;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class SetupTestData {

    public static void main(String[] args) {
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
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
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

}
