/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Date;

/**
 *
 * @author cecilie
 */
public class FilterDTO {
    
    private String from;
    private String to;
    private Date arrival;
    private Date departure;

    public FilterDTO(String from, String to, String arrival, String departure) {
        this.from = from;
        this.to = to;
        this.arrival = Date.valueOf(arrival);
        this.departure = Date.valueOf(departure);
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public Date getArrival() {
        return arrival;
    }

    public Date getDeparture() {
        return departure;
    }

    @Override
    public String toString() {
        return "FilterDTO{" + "from=" + from + ", to=" + to + ", arrival=" + arrival + ", departure=" + departure + '}';
    }
    
}
