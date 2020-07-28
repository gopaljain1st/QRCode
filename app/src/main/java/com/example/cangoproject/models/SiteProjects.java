package com.example.cangoproject.models;

public class SiteProjects
{
    private int id;
    private String code,pendingTagging;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPendingAsset() {
        return pendingTagging;
    }

    public void setPendingTagging(String pendingTagging) {
        this.pendingTagging = pendingTagging;
    }

    public SiteProjects(int id, String code, String pendingAsset) {
        this.id = id;
        this.code = code;
        this.pendingTagging = pendingAsset;
    }
}
