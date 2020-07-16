package com.example.cangoproject;


import java.io.Serializable;

public class Product implements Serializable
{
    String id,name,type,price,productType,assetState,vendor,assetType,assetCategory,assocutationGate,expiryDate,seriorNo,region,site,location,deparment,managedBy;

    public Product(String id, String name, String type, String price, String productType, String assetState, String vendor, String assetType, String assetCategory, String assocutationGate, String expiryDate, String seriorNo, String region, String site, String location, String deparment, String managedBy) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.productType = productType;
        this.assetState = assetState;
        this.vendor = vendor;
        this.assetType = assetType;
        this.assetCategory = assetCategory;
        this.assocutationGate = assocutationGate;
        this.expiryDate = expiryDate;
        this.seriorNo = seriorNo;
        this.region = region;
        this.site = site;
        this.location = location;
        this.deparment = deparment;
        this.managedBy = managedBy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getAssetState() {
        return assetState;
    }

    public void setAssetState(String assetState) {
        this.assetState = assetState;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public String getAssetCategory() {
        return assetCategory;
    }

    public void setAssetCategory(String assetCategory) {
        this.assetCategory = assetCategory;
    }

    public String getAssocutationGate() {
        return assocutationGate;
    }

    public void setAssocutationGate(String assocutationGate) {
        this.assocutationGate = assocutationGate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getSeriorNo() {
        return seriorNo;
    }

    public void setSeriorNo(String seriorNo) {
        this.seriorNo = seriorNo;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDeparment() {
        return deparment;
    }

    public void setDeparment(String deparment) {
        this.deparment = deparment;
    }

    public String getManagedBy() {
        return managedBy;
    }

    public void setManagedBy(String managedBy) {
        this.managedBy = managedBy;
    }
}
