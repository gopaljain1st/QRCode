package com.example.cangoproject.models;

public class SiteName
{
    int id;
    String Name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public SiteName(int id, String name) {
        this.id = id;
        Name = name;
    }
}
