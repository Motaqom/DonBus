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

public class RouteFragment extends TransportFragment {

    public RouteFragment() {
    }

    public static RouteFragment newInstance() {
        RouteFragment fragment = new RouteFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_route, container, false);
        ListView listView = view.findViewById(R.id.list);
        ArrayList routes = JsonHandler.readFromJson(getContext(), "routes.txt", JsonHandler.getListType(new TypeToken<List<RouteInfo>>(){}));
        RouteAdapter routeAdapter = new RouteAdapter(getActivity(), R.layout.list_item, routes);
        listView.setAdapter(routeAdapter);
        return view;
    }
}

