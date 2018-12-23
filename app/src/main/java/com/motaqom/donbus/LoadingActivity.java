package com.motaqom.donbus;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class LoadingActivity extends AppCompatActivity {
    private static final String TAG = "LoadingActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        while (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_NETWORK_STATE) != PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[] { Manifest.permission.ACCESS_NETWORK_STATE, Manifest.permission.WRITE_EXTERNAL_STORAGE }, 12);
        }
        for(int i = 0;i<Data.files.length;i++){
            if(!JsonHandler.hasFile(getApplicationContext(), Data.files[i])){
                JsonHandler.writeFile(getApplicationContext(), Data.filePath+Data.files[i], Data.data[i].getBytes());
            }
        }
        new UpdateList().execute();
    }

    private class UpdateList extends AsyncTask<Void, Void, Void> {
        protected Void doInBackground(Void... voids) {
                if (InternetHandler.server()) {
                    for (int i = 0; i < Data.files.length; i++) {
                        try {
                            String json = null;
                            json = new Scanner(new URL(Data.urls[i]).openStream(), "UTF-8").useDelimiter("\\A").next();
                            if(!json.getBytes().equals(Data.data[i])){
                                JsonHandler.writeFile(getApplicationContext(), Data.files[i], json.getBytes());
                            }
                        } catch (Exception e) {
                        }
                    }
                }else{

                    for (int i = 0; i < Data.files.length; i++) {
                        if(!JsonHandler.hasFile(getApplicationContext(), Data.files[i])){
                            try {
                                String json = null;
                                InputStream ins = getResources().openRawResource(getResources().getIdentifier(Data.local[i], "raw", getPackageName()));
                                json = new Scanner(ins, "UTF-8").useDelimiter("\\A").next();
                                if(!json.getBytes().equals(Data.data[i])){
                                    JsonHandler.writeFile(getApplicationContext(), Data.files[i], json.getBytes());
                                }
                            } catch (Exception e) {
                            }
                        }

                    }
                }
                onPostExecute();
            return null;
        }

        protected void onPostExecute() {
              Intent intent = new Intent(getApplicationContext(), MainActivity.class);
              intent.putExtra("first", true);
              startActivity(intent);
        }
    }
}
