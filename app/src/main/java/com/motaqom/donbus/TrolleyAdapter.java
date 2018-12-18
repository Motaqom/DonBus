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

public class TrolleyAdapter extends ArrayAdapter<TrolleyInfo> {
    private LayoutInflater inflater;
    private int layout;
    private List<TrolleyInfo> trolleys;

    public TrolleyAdapter(Context context, int resource,  List<TrolleyInfo> trolleys) {
        super(context, resource, trolleys);
        this.inflater = LayoutInflater.from(context);
        this.trolleys = trolleys;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view  = inflater.inflate(R.layout.list_item, parent, false);
        TextView id = (TextView) view.findViewById(R.id.id);
        TextView from = (TextView) view.findViewById(R.id.from);
        TextView to = (TextView) view.findViewById(R.id.to);
        TextView from1 = (TextView) view.findViewById(R.id.from1);
        TextView to1 = (TextView) view.findViewById(R.id.to1);
        TextView price = (TextView) view.findViewById(R.id.price);
        TrolleyInfo trolley = trolleys.get(position);
        id.setText(trolley.getId());
        Toolbar divider = (Toolbar) view.findViewById(R.id.divider);
        divider.setBackgroundColor(view.getContext().getResources().getColor(R.color.trolley_color));
        id.setTextColor(view.getContext().getResources().getColor(R.color.trolley_color));
        from.setText(trolley.getFrom());
        to.setText(trolley.getTo());
        from1.setText(trolley.getFrom());
        to1.setText(trolley.getTo());
        price.setText(trolley.getPrice());
        return view;
    }
}
