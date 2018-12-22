package com.motaqom.donbus;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class ThankyouActivity extends AppCompatActivity {
    RatingBar ratingBar;
    TextView textView;
    String output;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thankyou);
        textView = findViewById(R.id.text);
        ratingBar = findViewById(R.id.ratingBar);
        Bundle extras = getIntent().getExtras();
        String rate = extras.getString("Rate");
        String name = extras.getString("Name");
        textView.setText(getResources().getText(R.string.thanks)+name);
        ratingBar.setRating(Float.parseFloat(rate));
        output = name+" - "+rate+".";
    }
    public void Exit(View view){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("first", true);
        startActivity(intent);
    }
}