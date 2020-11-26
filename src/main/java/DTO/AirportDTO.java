/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import entities.Airport;
import java.util.List;

/**
 *
 * @author rh
 */
public class AirportDTO {
    
    private String country;
    private String airportname;
    private List<String> destinations;
    private List<String> takeoffs;

    public AirportDTO(Airport airport) {
        this.country = airport.getCountry().getCountryName();
        this.airportname = airport.getAirportName();
        this.destinations = airport.getDestinationsNameList();
        this.takeoffs = airport.getTakeoffNameList();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAirportname() {
        return airportname;
    }

    public void setAirportname(String airportname) {
        this.airportname = airportname;
    }

    public List<String> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<String> destinations) {
        this.destinations = destinations;
    }

    public List<String> getTakeoffs() {
        return takeoffs;
    }

    public void setTakeoffs(List<String> takeoffs) {
        this.takeoffs = takeoffs;
    }
    
    
    
    
}
