package com.app.ivansuhendra.warehousegla.model;

import com.google.gson.annotations.SerializedName;

public class Model {
    private int id;
    private String name;

    public Model(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
