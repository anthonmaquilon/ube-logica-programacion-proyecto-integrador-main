package com.ube.proyintegrador.models;

import java.util.Date;

public class PlcReading {
    private int id;
    private Date timestamp;
    private String tag;
    private double value;
    private String status;
    private String description;

    public PlcReading(int id, Date timestamp, String tag, double value, String status, String description) {
        this.id = id;
        this.timestamp = timestamp;
        this.tag = tag;
        this.value = value;
        this.status = status;
        this.description = description;
    }

    public int getId() { return id; }
    public Date getTimestamp() { return timestamp; }
    public String getTag() { return tag; }
    public double getValue() { return value; }
    public String getStatus() { return status; }
    public String getDescription() { return description; }
}
