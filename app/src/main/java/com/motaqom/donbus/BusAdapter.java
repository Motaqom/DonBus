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

public class BusAdapter extends ArrayAdapter<BusInfo> {
    private LayoutInflater inflater;
    private int layout;
    private List<BusInfo> buss;

    public BusAdapter(Context context, int resource,  List<BusInfo> buss) {
        super(context, resource, buss);
        this.inflater = LayoutInflater.from(context);
        this.buss = buss;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view  = inflater.inflate(R.layout.list_item, parent, false);
        TextView id = (TextView) view.findViewById(R.id.id);
        TextView from = (TextView) view.findViewById(R.id.from);
        TextView to = (TextView) view.findViewById(R.id.to);
        TextView from1 = (TextView) view.findViewById(R.id.from1);
        TextView to1 = (TextView) view.findViewById(R.id.to1);
        TextView price = (TextView) view.findViewById(R.id.price);
        BusInfo bus = buss.get(position);
        Toolbar divider = view.findViewById(R.id.divider);
        id.setText(bus.getId());
        id.setTextColor(view.getContext().getResources().getColor(R.color.bus_color));
        divider.setBackgroundColor(view.getContext().getResources().getColor(R.color.bus_color));
        from.setText(bus.getFrom());
        to.setText(bus.getTo());
        from1.setText(bus.getFrom());
        to1.setText(bus.getTo());
        price.setText(bus.getPrice());
        return view;
    }
}
