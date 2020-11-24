/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import DTO.demo.FlightDTO;
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

    //returns all flights in local database. 
    public List<FlightDTO> getAllFligth() {
        EntityManager em = emf.createEntityManager();
        
        try {
            TypedQuery<Flight> query = em.createQuery("SELECT f FROM Flight F", Flight.class);
            List<Flight> flights = new ArrayList();
            flights = query.getResultList();
            List<FlightDTO> allFlights = new ArrayList();
            for (Flight f : query.getResultList()) {
                allFlights.add(new FlightDTO(f));
            }
            System.out.println("Size Flight " + flights.size());
            return allFlights;
        } finally {
            em.close();
        }
    }
    
    
   

}
