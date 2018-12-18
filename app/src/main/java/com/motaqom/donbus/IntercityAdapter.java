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

public class IntercityAdapter extends ArrayAdapter<IntercityInfo> {
    private LayoutInflater inflater;
    private int layout;
    private List<IntercityInfo> intercitys;

    public IntercityAdapter(Context context, int resource,  List<IntercityInfo> intercitys) {
        super(context, resource, intercitys);
        this.inflater = LayoutInflater.from(context);
        this.intercitys = intercitys;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view  = inflater.inflate(R.layout.list_inter, parent, false);
        ImageView CoA = (ImageView) view.findViewById(R.id.CoA);
        TextView from = (TextView) view.findViewById(R.id.from);
        TextView to = (TextView) view.findViewById(R.id.to);
        TextView from1 = (TextView) view.findViewById(R.id.from1);
        TextView to1 = (TextView) view.findViewById(R.id.to1);
        TextView price = (TextView) view.findViewById(R.id.price);
        IntercityInfo intercity = intercitys.get(position);
        CoA.setImageResource(intercity.getCoA());
        Toolbar divider = (Toolbar) view.findViewById(R.id.divider);
        divider.setBackgroundColor(view.getContext().getResources().getColor(R.color.intercity_color));
        from.setText(intercity.getFrom());
        to.setText(intercity.getTo());
        from1.setText(intercity.getFrom());
        to1.setText(intercity.getTo());
        price.setText(intercity.getPrice());
        return view;
    }
}
