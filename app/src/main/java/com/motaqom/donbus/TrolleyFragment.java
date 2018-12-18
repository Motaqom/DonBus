package com.motaqom.donbus;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;

public class TrolleyFragment extends TransportFragment {

    public TrolleyFragment() {
    }

    public static TrolleyFragment newInstance() {
        TrolleyFragment fragment = new TrolleyFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trolley, container, false);
        ListView listView = view.findViewById(R.id.list);
        ArrayList<TrolleyInfo> trolleys = JsonHandler.readFromJson(getContext(), "trolleys.txt", JsonHandler.getListType(new TypeToken<List<TrolleyInfo>>() {}));
        TrolleyAdapter trolleyAdapter = new TrolleyAdapter(getActivity(), R.layout.list_item, trolleys);
        listView.setAdapter(trolleyAdapter);
        return view;
    }
}

