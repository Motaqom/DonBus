package com.motaqom.donbus;

import android.content.Intent;
import android.icu.text.IDNA;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class    InfoActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener{
    public boolean online = false;
    public boolean reach = false;
    public TextView internet, server;
    public ProgressBar pbI, pbS;
    public SwipeRefreshLayout swipeLayout;
    public Button btnRate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        btnRate = findViewById(R.id.btnRate);
        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_container);
        swipeLayout.setOnRefreshListener(this);
        swipeLayout.setColorScheme(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        new ping().execute();
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                swipeLayout.setRefreshing(false);
            }
        }, 100);
        new ping().execute();
    }

    private class ping extends AsyncTask<Void, Void, Void> {
        boolean connected = false;
        boolean site = false;
        String google = "8.8.8.8";
        String motaqom = "https://motaqom.com/donbus/database/trams.json";
        @Override
        protected Void doInBackground(Void... voids) {
            connected = InternetHandler.internet();
            site = InternetHandler.server();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            online = connected;
            reach = site;
            server = findViewById(R.id.server);
            internet = findViewById(R.id.internet);
            if(connected){
                internet.setText("Yes");
                internet.setTextColor(getResources().getColor(R.color.intercity_color));
            }else{
                internet.setText("No");
                internet.setTextColor(getResources().getColor(R.color.suburban_color));
            }
            if(reach){
                internet.setText("Yes");
                internet.setTextColor(getResources().getColor(R.color.intercity_color));
                server.setText("Yes");
                server.setTextColor(getResources().getColor(R.color.intercity_color));
            }else{
                server.setText("No");
                server.setTextColor(getResources().getColor(R.color.suburban_color));
            }
        }

    }
    public void rateApp(){
        Intent intent = new Intent(this, RateActivity.class);
        startActivity(intent);
    }

}
