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

public class SuburbanFragment extends TransportFragment {

    public SuburbanFragment() {
    }

    public static SuburbanFragment newInstance() {
        SuburbanFragment fragment = new SuburbanFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_suburban, container, false);
        ListView listView = view.findViewById(R.id.list);
        ArrayList suburbans = JsonHandler.readFromJson(getContext(), "suburbans.txt", JsonHandler.getListType(new TypeToken<List<SuburbanInfo>>(){}));
        SuburbanAdapter suburbanAdapter = new SuburbanAdapter(getActivity(), R.layout.list_item, suburbans);
        listView.setAdapter(suburbanAdapter);
        return view;
    }
}

