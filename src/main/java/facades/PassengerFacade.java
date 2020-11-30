/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Flight;
import entities.Passenger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author rh
 */
public class PassengerFacade {

    private static PassengerFacade instance;
    private static EntityManagerFactory emf;
    
     private PassengerFacade() {
        
    }

    public static PassengerFacade getFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new PassengerFacade();
        }
        return instance;
    }
    
   

    public Passenger getPassengerByName(String firstName, String lastName ) {
        EntityManager em = emf.createEntityManager();
        try {
            Passenger pass = new Passenger();
            TypedQuery<Passenger> query = em.createQuery(
                    "SELECT p FROM Passenger p "
                    + "WHERE :firstName = :firstName "
                    + "AND :lastName = :lastName"
                    , Passenger.class)
                    .setParameter("firstName", firstName)
                    .setParameter("lastName", lastName);
            pass = query.getSingleResult();
            return pass;

        } finally {
            em.close();

        }
    }
    
    public Passenger getPassengerById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Passenger> query = em.createQuery("SELECT p FROM Passenger p WHERE :id = :id", Passenger.class).setParameter("id", id);
            return query.getSingleResult();
        } finally {
            em.close();

        }
    }
}
