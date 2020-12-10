/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author hassanainali
 */
@Entity
public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Flight flight;
    @ManyToOne
    private Passenger passengerInfo;
    private Date created;
    
    

    public Booking() {
    }

    public Booking(Flight flight, Passenger passengerInfo) {
        this.flight = flight;
        this.passengerInfo = passengerInfo;
        this.created = new Date(System.currentTimeMillis());
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Passenger getPassengerInfo() {
        return passengerInfo;
    }

    public void setPassengerInfo(Passenger passengerInfo) {
        this.passengerInfo = passengerInfo;
    }

    @Override
    public String toString() {
        return "Booking{" + "id=" + id + ", flight=" + flight + ", passengerInfo=" + passengerInfo + ", created=" + created + '}';
    }
}
