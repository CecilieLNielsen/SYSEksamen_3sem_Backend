/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import DTO.FilterDTO;
import DTO.FlightDTO;
import entities.Airport;
import entities.Flight;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TemporalType;
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

    public List<FlightDTO> getFlightsByAirport(String airport) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Flight> query = em.createQuery("SELECT f FROM Flight f "
                    + "WHERE :airport = :airport", Flight.class).setParameter("airport", airport);

            List<FlightDTO> flightsByAirport = new ArrayList();
            for (Flight f : query.getResultList()) {
                flightsByAirport.add(new FlightDTO(f));
            }
            System.out.println("Size flight " + flightsByAirport.size());
            return flightsByAirport;
        } finally {
            em.close();
        }
    }

    public FlightDTO getFlightById(int id) {
        return new FlightDTO(getFlightEntityById(id));
    }

    public Flight getFlightEntityById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            Flight f = em.find(Flight.class, id);
            return f;
        } finally {
            em.close();
        }
    }

    public List<FlightDTO> getAllFlightsByFilter(FilterDTO filterDTO) {
        EntityManager em = emf.createEntityManager();
        try {
            // Jeg har prøvet at bruge TemporalType.DATE og prøvet at typecaste f.arrival til en date (sådan her: DATE(f.arrival)) Men jeg kunne ikke få dem til at virke (jeg har kommenteret dem ud)
            TypedQuery<Flight> query = em.createQuery("SELECT f FROM Flight f WHERE f.takeoffAirport.country.countryName = :from AND f.destinationAirport.country.countryName = :to", Flight.class);// AND f.arrival = :arrival", Flight.class); // AND DATE(f.arrival) = :arrival", Flight.class);
            query.setParameter("from", filterDTO.getFrom());
            query.setParameter("to", filterDTO.getTo());
            //query.setParameter("arrival", filterDTO.getArrival()); , TemporalType.DATE);

            List<FlightDTO> flights = new ArrayList();
            for (Flight f : query.getResultList()) {
                // Grundet til skjulte timestamps i datoer kunne jeg ikke bruge equals metoden...
                // Boolean compareDates = f.getArrival().equals(filterDTO.getArrival());
                // Men jeg har kunne hente årstal, måned og dag ud og sammenligne dem sådan...
                boolean compareDates = (f.getArrival().getYear() == filterDTO.getArrival().getYear()) 
                        && (f.getArrival().getMonth() == filterDTO.getArrival().getMonth()) 
                        && (f.getArrival().getDay() == filterDTO.getArrival().getDay());
                if (compareDates) {
                    flights.add(new FlightDTO(f));
                }
            }
            return flights;
        } finally {
            em.close();
        }
    }

}
