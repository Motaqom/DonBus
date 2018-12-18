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

public class TramAdapter extends ArrayAdapter<TramInfo> {
    private LayoutInflater inflater;
    private int layout;
    private List<TramInfo> trams;

    public TramAdapter(Context context, int resource,  List<TramInfo> trams) {
        super(context, resource, trams);
        this.inflater = LayoutInflater.from(context);
        this.trams = trams;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view  = inflater.inflate(R.layout.list_item, parent, false);
        TextView id = (TextView) view.findViewById(R.id.id);
        TextView from = (TextView) view.findViewById(R.id.from);
        TextView to = (TextView) view.findViewById(R.id.to);
        TextView from1 = (TextView) view.findViewById(R.id.from1);
        TextView to1 = (TextView) view.findViewById(R.id.to1);
        TextView price = (TextView) view.findViewById(R.id.price);
        TramInfo tram = trams.get(position);
        id.setText(tram.getId());
        Toolbar divider = (Toolbar) view.findViewById(R.id.divider);
        divider.setBackgroundColor(view.getContext().getResources().getColor(R.color.tram_color));
        id.setTextColor(view.getContext().getResources().getColor(R.color.tram_color));
        from.setText(tram.getFrom());
        to.setText(tram.getTo());
        from1.setText(tram.getFrom());
        to1.setText(tram.getTo());
        price.setText(tram.getPrice());
        return view;
    }
}
