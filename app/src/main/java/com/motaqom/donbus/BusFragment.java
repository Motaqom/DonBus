package com.motaqom.donbus;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.text.BoringLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BusFragment extends TransportFragment {
    ArrayList<BusInfo> buss;
    public BusFragment() {
    }

    public static BusFragment newInstance() {
        BusFragment fragment = new BusFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bus, container, false);
        ListView listView = view.findViewById(R.id.list);
        buss = JsonHandler.readFromJson(getContext(), "buss.txt", JsonHandler.getListType(new TypeToken<List<BusInfo>>(){}));
        BusAdapter busAdapter = new BusAdapter(getActivity(), R.layout.list_item, buss);
        listView.setAdapter(busAdapter);
        return view;
    }
}

