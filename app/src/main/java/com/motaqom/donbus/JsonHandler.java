package com.motaqom.donbus;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class JsonHandler {

    public static String readFile(Context context, String fileName) {
        try {
            StringBuilder text = new StringBuilder();
            FileInputStream fis = context.openFileInput(fileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(new BufferedInputStream(fis)));

            String line;
            while ((line = br.readLine()) != null) {
                text.append(line);
                text.append('\n');
            }
            br.close();
            return text.toString();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String readFile(Context context, File file) {
        try {
            StringBuilder text = new StringBuilder();
            FileInputStream fis = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(new BufferedInputStream(fis)));

            String line;
            while ((line = br.readLine()) != null) {
                text.append(line);
                text.append('\n');
            }
            br.close();
            return text.toString();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeFile(Context context, String file, byte[] input){
        try {
            FileOutputStream outputStream;
            outputStream = context.openFileOutput(file, Context.MODE_PRIVATE);
            outputStream.write(input);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static boolean hasFile(Context context, String filename){
        boolean output = false;
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
            File file = new File(Data.filePath+filename);
            output = file.exists();
        }
        return output;
    }

    public static ArrayList readFromJson(Context context, String json, Type listType){
        Gson gson = new Gson();
        String data = readFile(context, json);
        return gson.fromJson(data, listType);
    }
    public static ArrayList readFromJson(Context context, File file, Type listType){
        Gson gson = new Gson();
        String data = readFile(context, file);
        return gson.fromJson(data, listType);
    }

    public static Type getListType(TypeToken token){
        return token.getType();
    }

    public static ArrayList readFromJsonString(String json, Type listType){
        Gson gson = new Gson();
        return gson.fromJson(json, listType);
    }
}
