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

public class IntercityFragment extends TransportFragment {

    public IntercityFragment() {
    }

    public static IntercityFragment newInstance() {
        IntercityFragment fragment = new IntercityFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_intercity, container, false);
        ListView listView = view.findViewById(R.id.list);
        ArrayList intercitys = JsonHandler.readFromJson(getContext(), "intercitys.txt", JsonHandler.getListType(new TypeToken<List<IntercityInfo>>(){}));
        IntercityAdapter intercityAdapter = new IntercityAdapter(getActivity(), R.layout.list_inter, intercitys);
        listView.setAdapter(intercityAdapter);
        return view;
    }
}

