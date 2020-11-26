/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author rh
 */
@Entity
public class Country implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String countryName;
    
    @OneToMany
    private List<Airport> airports;

    public Country(int id, String countryName, List<Airport> airports) {
        this.id = id;
        this.countryName = countryName;
        this.airports = airports;
    }

    public Country(String countryName, List<Airport> airports) {
        this.countryName = countryName;
        this.airports = airports;
    }

    public Country() {
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName, List<Airport> airports ) {
        this.countryName = countryName;
        this.airports = airports;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Airport> getAirports() {
        return airports;
    }

    public void setAirports(List<Airport> airports) {
        this.airports = airports;
    }
}
