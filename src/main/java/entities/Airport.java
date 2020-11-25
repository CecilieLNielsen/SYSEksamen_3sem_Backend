/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author rh
 */
@Entity
public class Airport implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Country country;

    private String airportName;
   
    private List<Flight> destinations;
    
    private List<Flight> takeoffs;

    public Airport(Long id, Country country, String airportName, List<Flight> destinations, List<Flight> takeoffs) {
        this.id = id;
        this.country = country;
        this.airportName = airportName;
        this.destinations = destinations;
        this.takeoffs = takeoffs;
    }

    public Airport(Country country, String airportName, List<Flight> destinations, List<Flight> takeoffs) {
        this.country = country;
        this.airportName = airportName;
        this.destinations = destinations;
        this.takeoffs = takeoffs;
    }

    public Airport() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public List<Flight> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<Flight> destinations) {
        this.destinations = destinations;
    }

    public List<Flight> getTakeoffs() {
        return takeoffs;
    }

    public void setTakeoffs(List<Flight> takeoffs) {
        this.takeoffs = takeoffs;
    }

    //gives a list of destinations
    public List<String> getDestinationsNameList() {
        List<String> destinationNameList = new ArrayList();
        for (Flight f : this.getDestinations()) {
            destinationNameList.add(f.getDestinationAirport().getAirportName());
        }
        return destinationNameList;
    }
    //gives a list of takeoffs
    public List<String> getTakeoffNameList() {
        List<String> takeoffList = new ArrayList();
        for (Flight f : this.getDestinations()) {
            takeoffList.add(f.getTakeoffAirport().getAirportName());
        }
        return takeoffList;
    }
}
