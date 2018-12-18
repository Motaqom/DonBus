package com.motaqom.donbus;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;

public class TrainFragment extends TransportFragment {

    public TrainFragment() {
    }

    public static TrainFragment newInstance() {
        TrainFragment fragment = new TrainFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_train, container, false);
        ListView listView = view.findViewById(R.id.list);
        ArrayList trains = JsonHandler.readFromJson(getContext(), "trains.txt", JsonHandler.getListType(new TypeToken<List<TrainInfo>>(){}));
        TrainAdapter trainAdapter = new TrainAdapter(getActivity(), R.layout.list_train, trains);
        listView.setAdapter(trainAdapter);
        return view;
    }
}

