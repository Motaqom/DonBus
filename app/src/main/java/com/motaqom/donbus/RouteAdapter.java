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

public class RouteAdapter extends ArrayAdapter<RouteInfo> {
    private LayoutInflater inflater;
    private int layout;
    private List<RouteInfo> routes;

    public RouteAdapter(Context context, int resource,  List<RouteInfo> routes) {
        super(context, resource, routes);
        this.inflater = LayoutInflater.from(context);
        this.routes = routes;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view  = inflater.inflate(R.layout.list_item, parent, false);
        TextView id = (TextView) view.findViewById(R.id.id);
        TextView from = (TextView) view.findViewById(R.id.from);
        TextView to = (TextView) view.findViewById(R.id.to);
        TextView from1 = (TextView) view.findViewById(R.id.from1);
        TextView to1 = (TextView) view.findViewById(R.id.to1);
        TextView price = (TextView) view.findViewById(R.id.price);
        RouteInfo route = routes.get(position);
        id.setText(route.getId());
        Toolbar divider = (Toolbar) view.findViewById(R.id.divider);
        divider.setBackgroundColor(view.getContext().getResources().getColor(R.color.route_color));
        id.setTextColor(view.getContext().getResources().getColor(R.color.route_color));
        from.setText(route.getFrom());
        to.setText(route.getTo());
        from1.setText(route.getFrom());
        to1.setText(route.getTo());
        price.setText(route.getPrice());
        return view;
    }
}
