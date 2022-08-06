package com.coderclase11.clientes.model;

import java.util.Date;

public class WorldClock {

    //private String $id;
    private Date currentDateTime;

    public Date getCurrentDateTime() {
        return currentDateTime;
    }

    public void setCurrentDateTime(Date currentDateTime) {
        this.currentDateTime = currentDateTime;
    }
}