/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author cecilie
 */
public class MakeBookingDTO {

    private final int flightId;
    private final int userId;
    private final int id;

    public MakeBookingDTO(int id, int flightId, int userId) {
        this.flightId = flightId;
        this.userId = userId;
        this.id = id;
    }

    public int getFlightId() {
        return flightId;
    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }
    
    

}
