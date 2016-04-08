package com.example.askin.merdivan;

/**
 * Created by Askin on 21.12.2015.
 */
public class citysdk {


    private String type;
    private String name;
    private String layer;

    public citysdk(String type, String name, String layer) {
        this.type = type;
        this.name = name;
        this.layer = layer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLayer() {
        return layer;
    }

    public void setLayer(String layer) {
        this.layer = layer;
    }
}
