package com.example.askin.merdivan;

/**
 * Created by KAAN BURAK ŞENER on 11/5/2015.
 */

public class Observation {
    private int id;
    private String topic;
    private String status;
    private String user;
    private int vote;
    private String date;
    private String summary;
    private String address;
    private double lat;
    private double lng;
    private String image;

    public Observation(int id, String topic, String status, String user, int vote, String date, String summary, String address, double lat, double lng, String image) {
        super();
        this.id = id;
        this.topic = topic;
        this.status = status;
        this.user = user;
        this.vote = vote;
        this.date = date;
        this.summary = summary;
        this.address = address;
        this.lat = lat;
        this.lng = lng;
        this.image= image;
    }

    public Observation(int id, String topic, String status, String user, int vote, String date, String summary, String address, double lat, double lng) {
        super();
        this.id = id;
        this.topic = topic;
        this.status = status;
        this.user = user;
        this.vote = vote;
        this.date = date;
        this.summary = summary;
        this.address = address;
        this.lat = lat;
        this.lng = lng;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) { this.lat = lat;}

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) { this.lng = lng;}

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
