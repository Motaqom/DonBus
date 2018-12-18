package com.motaqom.donbus;

import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class TrainInfo {
    private String price;
    private String from;
    private String to;

    public TrainInfo() {
    }

    public TrainInfo(String price, String from, String to) {

        this.price = price;
        this.from = from;
        this.to = to;
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

