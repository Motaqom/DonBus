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

public class TrainAdapter extends ArrayAdapter<TrainInfo> {
    private LayoutInflater inflater;
    private int layout;
    private List<TrainInfo> trains;

    public TrainAdapter(Context context, int resource,  List<TrainInfo> trains) {
        super(context, resource, trains);
        this.inflater = LayoutInflater.from(context);
        this.trains = trains;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view  = inflater.inflate(R.layout.list_train, parent, false);
        TextView from = (TextView) view.findViewById(R.id.from);
        TextView to = (TextView) view.findViewById(R.id.to);
        TextView from1 = (TextView) view.findViewById(R.id.from1);
        TextView to1 = (TextView) view.findViewById(R.id.to1);
        TextView price = (TextView) view.findViewById(R.id.price);
        TrainInfo train = trains.get(position);
        Toolbar divider = (Toolbar) view.findViewById(R.id.divider);
        divider.setBackgroundColor(view.getContext().getResources().getColor(R.color.train_color));
        from.setText(train.getFrom());
        to.setText(train.getTo());
        from1.setText(train.getFrom());
        to1.setText(train.getTo());
        price.setText(train.getPrice());
        return view;
    }
}
