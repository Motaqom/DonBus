package com.motaqom.donbus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TimetableActivity extends AppCompatActivity {
    String json;
    String id;
    String start;
    String end;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);
        Bundle extras = getIntent().getExtras();
        Spinner spinner = findViewById(R.id.spinner);
        ArrayList stops = JsonHandler.readFromJson(this, "stops.txt", JsonHandler.getListType(new TypeToken<List<StopInfo>>(){}));
        StopAdapter stopAdapter = new StopAdapter(this, R.layout.list_time, stops);
        spinner.setAdapter(stopAdapter);
    }
}
