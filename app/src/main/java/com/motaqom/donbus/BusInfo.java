package com.motaqom.donbus;

import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class BusInfo {
    private String id;
    private String price;
    private String from;
    private String to;

    public BusInfo() {
    }

    public BusInfo(String id, String price, String from, String to) {

        this.id = id;
        this.price = price;
        this.from = from;
        this.to = to;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}

