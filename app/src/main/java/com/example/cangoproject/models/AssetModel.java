package com.example.cangoproject.models;

public class AssetModel {
    String asset_name,asset_id,asset_number;
    int asset_image;

    public AssetModel(String asset_name, String asset_id, String asset_number, int asset_image) {
        this.asset_name = asset_name;
        this.asset_id = asset_id;
        this.asset_number = asset_number;
        this.asset_image = asset_image;
    }

    public String getAsset_name() {
        return asset_name;
    }

    public void setAsset_name(String asset_name) {
        this.asset_name = asset_name;
    }

    public String getAsset_id() {
        return asset_id;
    }

    public void setAsset_id(String asset_id) {
        this.asset_id = asset_id;
    }

    public String getAsset_number() {
        return asset_number;
    }

    public void setAsset_number(String asset_number) {
        this.asset_number = asset_number;
    }

    public int getAsset_image() {
        return asset_image;
    }

    public void setAsset_image(int asset_image) {
        this.asset_image = asset_image;
    }
}
