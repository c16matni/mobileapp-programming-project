package com.example.project;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("WeakerAccess")
public class RecyclerViewItem {


    @SerializedName("name")
    private String namn;
    @SerializedName("company")
    private String latin;
    @SerializedName("category")
    private String familj;
    @SerializedName("auxdata")
    private String plats;

    public RecyclerViewItem(String namn, String latin, String familj, String plats ) {
        this.namn = namn;
        this.latin = latin;
        this.familj = familj;
        this.plats = plats;
    }

    public String getNamn() {
        return namn;
    }
    public String getLatin() {
        return latin;
    }
    public String getFamilj() {
        return familj;
    }
    public String getPlats() {
        return plats;
    }
}