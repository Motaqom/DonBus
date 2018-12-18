package com.motaqom.donbus;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.motaqom.donbus.R;
import com.motaqom.donbus.TramAdapter;
import com.motaqom.donbus.TramInfo;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class TransportFragment extends Fragment {

    private List<TramInfo> trams = new ArrayList();
    ListView list;
    private LayoutInflater inflater;
    private ViewGroup parent;

    private OnFragmentInteractionListener mListener;

    public TransportFragment() {
    }
    public static TransportFragment newInstance() {
        TransportFragment fragment = new TransportFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState, int list) {
        View view  = inflater.inflate(R.layout.fragment_tram, container, false);
        return view;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    public void getTimetable(Class<?> cls, String id, String start, String end){
        Intent intent = new Intent(getContext(), cls);
        intent.putExtra("id", id);
        intent.putExtra("start", start);
        intent.putExtra("end", end);
        startActivity(intent);
    }
}

