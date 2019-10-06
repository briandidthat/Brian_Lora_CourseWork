package com.trilogyed.roomservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int roomNumber;
    private String occupant;

    // SETTERS
    public void setId(int id) {
        this.id = id;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setOccupant(String occupant) {
        this.occupant = occupant;
    }

    // GETTERS
    public int getId() {
        return id;
    }
    public int getRoomNumber() {
        return roomNumber;
    }
    public String getOccupant() {
        return occupant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return id == room.id &&
                roomNumber == room.roomNumber &&
                occupant.equals(room.occupant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roomNumber, occupant);
    }
}
