/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author rh
 */
@Entity
public class Flight implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fligth_id;
    private String airline;
    private Destenation des;
    
    

    public Long getId() {
        return fligth_id;
    }

    public void setId(Long fligth_id) {
        this.fligth_id = fligth_id;
    }

    public Flight(String airline, Destenation des) {
        this.airline = airline;
        this.des = des;
    }

    public Flight() {
    }

    
    public Long getFligth_id() {
        return fligth_id;
    }

    public void setFligth_id(Long fligth_id) {
        this.fligth_id = fligth_id;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public Destenation getDes() {
        return des;
    }

    public void setDes(Destenation des) {
        this.des = des;
    }

    
    
}
