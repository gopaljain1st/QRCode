package com.example.cangoproject;

public class contact
{
    private String name;
    private int syncStatus;

    public contact(String name, int syncStatus) {
        this.name = name;
        this.syncStatus = syncStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(int syncStatus) {
        this.syncStatus = syncStatus;
    }
}
