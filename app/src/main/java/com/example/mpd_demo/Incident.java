package com.example.mpd_demo;

public class Incident {

    private String title = "";
    private String description = "";
    private String road = "";
    private String latitude = "";
    private String longitude = "";
    private String eventStart = "";
    private String eventEnd = "";


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }


    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getEventStart() {
        return eventStart;
    }

    public void setEventStart(String eventStart) {
        this.eventStart = eventStart;
    }

    public String getEventEnd() {
        return eventEnd;
    }

    public void setEventEnd(String eventEnd) {
        this.eventEnd = eventEnd;
    }

    public String toString()
    {
        String incident = "";
        incident+= "==========================" + "\n"
                +title + "\n"
                +"==========================" + "\n"
                +description     + "\n"
                +"==========================" + "\n"
                +road     + "\n"
                +"==========================" + "\n"
                +latitude     + "\n"
                +"==========================" + "\n"
                +longitude     + "\n"
                +"==========================" + "\n"
                +eventStart     + "\n"
                +"==========================" + "\n"
                +eventEnd + "\n"
                +"==========================" + "\n";

        return incident;
    }
}
