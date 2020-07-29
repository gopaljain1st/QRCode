package com.example.cangoproject.models;

public class Radio {
    String radio_name,radio_id,radio_unit;

    public Radio(String radio_name, String radio_id, String radio_unit) {
        this.radio_name = radio_name;
        this.radio_id = radio_id;
        this.radio_unit = radio_unit;
    }

    public String getRadio_name() {
        return radio_name;
    }

    public void setRadio_name(String radio_name) {
        this.radio_name = radio_name;
    }

    public String getRadio_id() {
        return radio_id;
    }

    public void setRadio_id(String radio_id) {
        this.radio_id = radio_id;
    }

    public String getRadio_unit() {
        return radio_unit;
    }

    public void setRadio_unit(String radio_unit) {
        this.radio_unit = radio_unit;
    }
}
