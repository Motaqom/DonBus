package com.motaqom.donbus;

import android.util.Log;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Scanner;

public class InternetHandler {

    public static boolean internet() {
        String google = "8.8.8.8";
        boolean connected = false;
        try {
            connected = InetAddress.getByName(google).isReachable(50);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connected;
    }
        public static boolean server(){
            boolean connected = false;
            String motaqom = "https://motaqom.com/donbus/database/trams.json";
            String json = null;
            try {
                json = new Scanner(new URL(motaqom).openStream(), "UTF-8").useDelimiter("\\A").next();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            if(json!=null){
                connected = true;
            }
            return connected;
    }
}
