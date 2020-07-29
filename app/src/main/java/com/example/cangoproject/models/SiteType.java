package com.example.cangoproject.models;

public class SiteType {
    String typeNumber,assetType;

    public SiteType(String typeNumber, String assetType) {
        this.typeNumber = typeNumber;
        this.assetType = assetType;
    }

    public String getTypeNumber() {
        return typeNumber;
    }

    public void setTypeNumber(String typeNumber) {
        this.typeNumber = typeNumber;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }
}
