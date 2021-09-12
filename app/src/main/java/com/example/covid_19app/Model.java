package com.example.covid_19app;

public class Model {
    private String districtName,active,confirmed,deceased,recovered,deltaConfirmed,deltaDeceased,deltaRecovered;


    public Model() {
    }

    public Model(String districtName, String active, String confirmed, String deceased, String recovered,
                 String deltaConfirmed, String deltaDeceased, String deltaRecovered) {
        this.districtName = districtName;
        this.active = active;
        this.confirmed = confirmed;
        this.deceased = deceased;
        this.recovered = recovered;
        this.deltaConfirmed = deltaConfirmed;
        this.deltaDeceased = deltaDeceased;
        this.deltaRecovered = deltaRecovered;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(String confirmed) {
        this.confirmed = confirmed;
    }

    public String getDeceased() {
        return deceased;
    }

    public void setDeceased(String deceased) {
        this.deceased = deceased;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getDeltaConfirmed() {
        return deltaConfirmed;
    }

    public void setDeltaConfirmed(String deltaConfirmed) {
        this.deltaConfirmed = deltaConfirmed;
    }

    public String getDeltaDeceased() {
        return deltaDeceased;
    }

    public void setDeltaDeceased(String deltaDeceased) {
        this.deltaDeceased = deltaDeceased;
    }

    public String getDeltaRecovered() {
        return deltaRecovered;
    }

    public void setDeltaRecovered(String deltaRecovered) {
        this.deltaRecovered = deltaRecovered;
    }
}
