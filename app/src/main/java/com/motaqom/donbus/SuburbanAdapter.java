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

public class SuburbanAdapter extends ArrayAdapter<SuburbanInfo> {
    private LayoutInflater inflater;
    private int layout;
    private List<SuburbanInfo> suburbans;

    public SuburbanAdapter(Context context, int resource,  List<SuburbanInfo> suburbans) {
        super(context, resource, suburbans);
        this.inflater = LayoutInflater.from(context);
        this.suburbans = suburbans;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view  = inflater.inflate(R.layout.list_item, parent, false);
        TextView id = (TextView) view.findViewById(R.id.id);
        TextView from = (TextView) view.findViewById(R.id.from);
        TextView to = (TextView) view.findViewById(R.id.to);
        TextView from1 = (TextView) view.findViewById(R.id.from1);
        TextView to1 = (TextView) view.findViewById(R.id.to1);
        TextView price = (TextView) view.findViewById(R.id.price);
        SuburbanInfo suburban = suburbans.get(position);
        id.setText(suburban.getId());
        Toolbar divider = (Toolbar) view.findViewById(R.id.divider);
        divider.setBackgroundColor(view.getContext().getResources().getColor(R.color.suburban_color));
        id.setTextColor(view.getContext().getResources().getColor(R.color.suburban_color));
        from.setText(suburban.getFrom());
        to.setText(suburban.getTo());
        from1.setText(suburban.getFrom());
        to1.setText(suburban.getTo());
        price.setText(suburban.getPrice());
        return view;
    }
}
