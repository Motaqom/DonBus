package com.motaqom.donbus;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;

public class TramFragment extends TransportFragment {

    public TramFragment() {
    }

    public static TramFragment newInstance() {
        TramFragment fragment = new TramFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tram, container, false);
        ListView listView = view.findViewById(R.id.list);
        ArrayList trams = JsonHandler.readFromJson(getContext(), "trams.txt", JsonHandler.getListType(new TypeToken<List<TramInfo>>(){}));
        TramAdapter tramAdapter = new TramAdapter(getActivity(), R.layout.list_item, trams);
        listView.setAdapter(tramAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View itemView, int i, long l){
               /* String data;
                    ArrayList<TimetableInfo> json = JsonHandler.readFromJson(getContext(), "bussTimetable.txt", JsonHandler.getListType(new TypeToken<List<TimetableInfo>>(){}));
                for(int j = 0; j<json.size();j++){
                    if (Integer.parseInt(json.get(j).getId()) == Integer.parseInt(buss.get(i).getId()))
                        getTimetable(TimetableActivity.class, buss.get(i).getId(), json.get(j).getStart(), json.get(j).getEnd());
                }*/
                Intent intent = new Intent(getActivity(), TimetableActivity.class);
                startActivity(intent);

            }
        });
        return view;
    }
}

