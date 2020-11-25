/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import entities.Country;
import java.util.List;

/**
 *
 * @author rh
 */
public class CountryDTO {

    private String countryName;
    private List<String> airports;

    public CountryDTO(Country country) {
        this.countryName = country.getCountryName();
        //this.airports = country.getAirports();  //skal laves om i airports så vi har en metode der giver hver elements navn. 
    }

    public String getCountryName() {
        return countryName;
    }

    public List<String> getAirports() {
        return airports;
    }
}
