/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import DTO.FlightDTO;
import entities.Airport;
import entities.Flight;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author rh
 */
public class FlightFacade {

    private static FlightFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private FlightFacade() {
    }

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static FlightFacade getFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new FlightFacade();
        }
        return instance;
    }

    public List<FlightDTO> getAllFligths() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Flight> query = em.createQuery("SELECT f FROM Flight f", Flight.class);
            List<FlightDTO> allFlights = new ArrayList();
            for (Flight f : query.getResultList()) {
                allFlights.add(new FlightDTO(f));
            }
            System.out.println("Size flight " + allFlights.size());
            return allFlights;
        } finally {
            em.close();
        }
    }
    
    public List<FlightDTO> getFlightsByAirport(String airport){
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Flight> query = em.createQuery("SELECT f FROM Flight f WHERE :airport = :airport", Flight.class).setParameter("airport", airport);
            
            List<FlightDTO> flightsByAirport = new ArrayList();
            for(Flight f : query.getResultList()){
                flightsByAirport.add(new FlightDTO(f));
            }
            System.out.println("Size flight " + flightsByAirport.size());
            return flightsByAirport;
        } finally {
            em.close();
        }
    }

}
