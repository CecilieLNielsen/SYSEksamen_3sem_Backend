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

    public MakeBookingDTO(int flightId, int userId) {
        this.flightId = flightId;
        this.userId = userId;
    }

    public int getFlightId() {
        return flightId;
    }

    public int getUserId() {
        return userId;
    }

}
