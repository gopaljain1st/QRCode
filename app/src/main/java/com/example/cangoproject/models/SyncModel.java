package com.example.cangoproject.models;

public class SyncModel {


    String syncName,syncId;

    public SyncModel(String syncName, String syncId) {
        this.syncName = syncName;
        this.syncId = syncId;
    }

    public String getSyncName() {
        return syncName;
    }

    public void setSyncName(String syncName) {
        this.syncName = syncName;
    }

    public String getSyncId() {
        return syncId;
    }

    public void setSyncId(String syncId) {
        this.syncId = syncId;
    }
}
