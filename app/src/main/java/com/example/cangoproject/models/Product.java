package com.example.cangoproject.models;

import android.graphics.Bitmap;

public class Product
{
    private int id;
    private String transactionId,serialNo,Quantity,assetId,towerId,radioUnitId,cabinetId,radioUnitBand,radioUnitPlacement,radioUnitType,status,acceptanceDate,integrationDate,projectCode,assetType,domainId,radioId,radioName,radioUnit;
    private Bitmap image;
    public Product(int id, String transactionId, String serialNo, String quantity, String assetId, String towerId, String radioUnitId, String cabinetId, String radioUnitBand, String radioUnitPlacement, String radioUnitType, String status, String acceptanceDate, String integrationDate, String projectCode, String assetType, String domainId, String radioId, String radioName, String radioUnit, Bitmap image) {
        this.id = id;
        this.transactionId = transactionId;
        this.serialNo = serialNo;
        Quantity = quantity;
        this.assetId = assetId;
        this.towerId = towerId;
        this.radioUnitId = radioUnitId;
        this.cabinetId = cabinetId;
        this.radioUnitBand = radioUnitBand;
        this.radioUnitPlacement = radioUnitPlacement;
        this.radioUnitType = radioUnitType;
        this.status = status;
        this.acceptanceDate = acceptanceDate;
        this.integrationDate = integrationDate;
        this.projectCode = projectCode;
        this.assetType = assetType;
        this.domainId = domainId;
        this.radioId = radioId;
        this.radioName = radioName;
        this.radioUnit = radioUnit;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public String getTowerId() {
        return towerId;
    }

    public void setTowerId(String towerId) {
        this.towerId = towerId;
    }

    public String getRadioUnitId() {
        return radioUnitId;
    }

    public void setRadioUnitId(String radioUnitId) {
        this.radioUnitId = radioUnitId;
    }

    public String getCabinetId() {
        return cabinetId;
    }

    public void setCabinetId(String cabinetId) {
        this.cabinetId = cabinetId;
    }

    public String getRadioUnitBand() {
        return radioUnitBand;
    }

    public void setRadioUnitBand(String radioUnitBand) {
        this.radioUnitBand = radioUnitBand;
    }

    public String getRadioUnitPlacement() {
        return radioUnitPlacement;
    }

    public void setRadioUnitPlacement(String radioUnitPlacement) {
        this.radioUnitPlacement = radioUnitPlacement;
    }

    public String getRadioUnitType() {
        return radioUnitType;
    }

    public void setRadioUnitType(String radioUnitType) {
        this.radioUnitType = radioUnitType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAcceptanceDate() {
        return acceptanceDate;
    }

    public void setAcceptanceDate(String acceptanceDate) {
        this.acceptanceDate = acceptanceDate;
    }

    public String getIntegrationDate() {
        return integrationDate;
    }

    public void setIntegrationDate(String integrationDate) {
        this.integrationDate = integrationDate;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public String getDomainId() {
        return domainId;
    }

    public void setDomainId(String domainId) {
        this.domainId = domainId;
    }

    public String getRadioId() {
        return radioId;
    }

    public void setRadioId(String radioId) {
        this.radioId = radioId;
    }

    public String getRadioName() {
        return radioName;
    }

    public void setRadioName(String radioName) {
        this.radioName = radioName;
    }

    public String getRadioUnit() {
        return radioUnit;
    }

    public void setRadioUnit(String radioUnit) {
        this.radioUnit = radioUnit;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
