package utils;

import entities.Airport;
import entities.Country;
import entities.Flight;
import entities.Role;
import entities.User;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class SetupTestUsers {

    public static void main(String[] args) {

        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
//        EntityManager em = emf.createEntityManager();
//
//        User user = new User("user", "123");
//        User admin = new User("admin", "123123");
//        User both = new User("user_admin", "123123123");
//        //Airport des = new Airport("Madrid");
//        //Flight f1 = new Flight("SAS", des);
//
//        if (admin.getUserPass().equals("test") || user.getUserPass().equals("test") || both.getUserPass().equals("test")) {
//            throw new UnsupportedOperationException("You have not changed the passwords");
//        }
//
//        em.getTransaction().begin();
//        Role userRole = new Role("user");
//        Role adminRole = new Role("admin");
//        user.addRole(userRole);
//        admin.addRole(adminRole);
//        both.addRole(userRole);
//        both.addRole(adminRole);
//        em.persist(userRole);
//        //em.persist(des);
//        //em.persist(f1);
//        em.persist(adminRole);
//        em.persist(user);
//        em.persist(admin);
//        em.persist(both);
//        em.getTransaction().commit();
//        System.out.println("PW: " + user.getUserPass());
//        System.out.println("Testing user with OK password: " + user.verifyPassword("test"));
//        System.out.println("Testing user with wrong password: " + user.verifyPassword("test1"));
//        System.out.println("Created TEST Users");

        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            List<Airport> airports = new ArrayList();
            Flight flight = new Flight();
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
