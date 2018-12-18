package com.motaqom.donbus;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class StopAdapter extends ArrayAdapter<StopInfo> {
    private LayoutInflater inflater;
    private int layout;
    private List<StopInfo> stops;

    public StopAdapter(Context context, int resource,  List<StopInfo> stops) {
        super(context, resource, stops);
        this.inflater = LayoutInflater.from(context);
        this.stops = stops;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view  = inflater.inflate(R.layout.list_item, parent, false);
        StopInfo stop = stops.get(position);
        TextView name = view.findViewById(R.id.name);
        //name.setText(stop.getName());
        return view;
    }
}
