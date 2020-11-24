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
    private Airport des;
    private Airport arival;
    private int price;

    public Flight(String airline, Airport des, Airport arival, int price) {
        this.airline = airline;
        this.des = des;
        this.arival = arival;
        this.price = price;
    }
    
    

    public Flight() {
    }

    public Long getId() {
        return fligth_id;
    }

    public void setId(Long fligth_id) {
        this.fligth_id = fligth_id;
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

    public Airport getDes() {
        return des;
    }

    public void setDes(Airport des) {
        this.des = des;
    }

    public Airport getArival() {
        return arival;
    }

    public void setArival(Airport arival) {
        this.arival = arival;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    
    
    
}
