package com.motaqom.donbus;

import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class IntercityInfo {
    private String CoA;
    private String price;
    private String from;
    private String to;

    public IntercityInfo() {
    }

    public IntercityInfo(String CoA, String price, String from, String to) {

        this.CoA = CoA;
        this.price = price;
        this.from = from;
        this.to = to;
    }

    public String getCoA() {
        return CoA;
    }

    public void setCoA(String CoA) {
        this.CoA = CoA;
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

