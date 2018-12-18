package com.motaqom.donbus;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentContainer;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Transition;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;

import static android.support.v4.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE;

public class MainActivity extends AppCompatActivity{

    ImageView icon;
    int bus_icon = R.drawable.bus;
    int train_icon = R.drawable.train;
    int tram_icon = R.drawable.tram;
    int currentIcon = tram_icon;
    private DrawerLayout mDrawerLayout;
    FrameLayout cont;
    Animation anim;
    private String prevFrag = "Exit";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anim = AnimationUtils.loadAnimation(this, R.anim.lefttoright);
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);
        setSupportActionBar(toolbar);

        Boolean first = false;
        first = getIntent().getBooleanExtra("first", false);
        if(first) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            TrolleyFragment trolleyFragment = new TrolleyFragment();
            toolbar.setTitle(getResources().getString(R.string.trolley_name));
            fragmentManager.beginTransaction().setTransition(TRANSIT_FRAGMENT_FADE).replace(R.id.fragment_container, trolleyFragment).commit();
            first = false;
        }

        while (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_NETWORK_STATE) != PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[] { Manifest.permission.ACCESS_NETWORK_STATE, Manifest.permission.WRITE_EXTERNAL_STORAGE }, 12);
        }

        mDrawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        cont = findViewById(R.id.fragment_container);
                        BusFragment busFragment = new BusFragment();
                        TramFragment tramFragment = new TramFragment();
                        TrolleyFragment trolleyFragment = new TrolleyFragment();
                        RouteFragment routeFragment = new RouteFragment();
                        SuburbanFragment suburbanFragment = new SuburbanFragment();
                        IntercityFragment intercityFragment = new IntercityFragment();
                        TrainFragment trainFragment = new TrainFragment();
                        switch(menuItem.getItemId()){
                            case R.id.nav_bus:
                                prevFrag = fragmentManager.getFragments().toString().substring(1,fragmentManager.getFragments().toString().indexOf("Fragment"));
                                toolbar.setTitle(getResources().getString(R.string.bus_name));
                                currentIcon = bus_icon;
                                fragmentManager.beginTransaction().setTransition(TRANSIT_FRAGMENT_FADE).replace(R.id.fragment_container, busFragment).commit();
                                break;
                            case R.id.nav_tram:
                                prevFrag = fragmentManager.getFragments().toString().substring(1,fragmentManager.getFragments().toString().indexOf("Fragment"));
                                toolbar.setTitle(getResources().getString(R.string.tram_name));
                                currentIcon = tram_icon;
                                fragmentManager.beginTransaction().setTransition(TRANSIT_FRAGMENT_FADE).replace(R.id.fragment_container, tramFragment).commit();
                                break;
                            case R.id.nav_trolley:
                                prevFrag = fragmentManager.getFragments().toString().substring(1,fragmentManager.getFragments().toString().indexOf("Fragment"));
                                toolbar.setTitle(getResources().getString(R.string.trolley_name));
                                currentIcon = tram_icon;
                                fragmentManager.beginTransaction().setTransition(TRANSIT_FRAGMENT_FADE).replace(R.id.fragment_container, trolleyFragment).commit();
                                break;
                            case R.id.nav_route:
                                prevFrag = fragmentManager.getFragments().toString().substring(1,fragmentManager.getFragments().toString().indexOf("Fragment"));
                                toolbar.setTitle(getResources().getString(R.string.route_name));
                                currentIcon = bus_icon;
                                fragmentManager.beginTransaction().setTransition(TRANSIT_FRAGMENT_FADE).replace(R.id.fragment_container, routeFragment).commit();
                                break;
                            case R.id.nav_sub:
                                prevFrag = fragmentManager.getFragments().toString().substring(1,fragmentManager.getFragments().toString().indexOf("Fragment"));
                                toolbar.setTitle(getResources().getString(R.string.suburban_name));
                                currentIcon = bus_icon;
                                fragmentManager.beginTransaction().setTransition(TRANSIT_FRAGMENT_FADE).replace(R.id.fragment_container, suburbanFragment).commit();
                                break;
                            case R.id.nav_inter:
                                prevFrag = fragmentManager.getFragments().toString().substring(1,fragmentManager.getFragments().toString().indexOf("Fragment"));
                                toolbar.setTitle(getResources().getString(R.string.inter_name));
                                currentIcon = bus_icon;
                                fragmentManager.beginTransaction().setTransition(TRANSIT_FRAGMENT_FADE).replace(R.id.fragment_container, intercityFragment).commit();
                                break;
                            case R.id.nav_train:
                                prevFrag = fragmentManager.getFragments().toString().substring(1,fragmentManager.getFragments().toString().indexOf("Fragment"));
                                toolbar.setTitle(getResources().getString(R.string.train_name));
                                currentIcon = train_icon;
                                fragmentManager.beginTransaction().setTransition(TRANSIT_FRAGMENT_FADE).replace(R.id.fragment_container, trainFragment).commit();
                                break;
                        }

                        return true;
                    }
                });
        mDrawerLayout.addDrawerListener(
                new DrawerLayout.DrawerListener() {
                    @Override
                    public void onDrawerSlide(View drawerView, float slideOffset) {
                        icon = drawerView.findViewById(R.id.icon);
                        icon.setImageResource(currentIcon);
                    }

                    @Override
                    public void onDrawerOpened(View drawerView) {
                        icon = drawerView.findViewById(R.id.icon);
                        icon.setImageResource(currentIcon);
                    }

                    @Override
                    public void onDrawerClosed(View drawerView) {
                        icon = drawerView.findViewById(R.id.icon);
                        icon.setImageResource(currentIcon);
                    }

                    @Override
                    public void onDrawerStateChanged(int newState) {
                    }
                }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.actionbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                    mDrawerLayout.openDrawer(GravityCompat.START);
                return true;

            case R.id.info:
                Intent intent = new Intent(this, InfoActivity.class);
                startActivity(intent);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
            Toolbar toolbar = findViewById(R.id.toolbar);
            FragmentManager fragmentManager = getSupportFragmentManager();
            BusFragment busFragment = new BusFragment();
            TramFragment tramFragment = new TramFragment();
            TrolleyFragment trolleyFragment = new TrolleyFragment();
            RouteFragment routeFragment = new RouteFragment();
            SuburbanFragment suburbanFragment = new SuburbanFragment();
            IntercityFragment intercityFragment = new IntercityFragment();
            TrainFragment trainFragment = new TrainFragment();
            switch(prevFrag){
                case "Bus":
                    toolbar.setTitle(getResources().getString(R.string.bus_name));
                    currentIcon = bus_icon;
                    fragmentManager.beginTransaction().setTransition(TRANSIT_FRAGMENT_FADE).replace(R.id.fragment_container, busFragment).commit();
                    break;
                case "Tram":
                    toolbar.setTitle(getResources().getString(R.string.tram_name));
                    currentIcon = tram_icon;
                    fragmentManager.beginTransaction().setTransition(TRANSIT_FRAGMENT_FADE).replace(R.id.fragment_container, tramFragment).commit();
                    break;
                case "Trolley":
                    toolbar.setTitle(getResources().getString(R.string.trolley_name));
                    currentIcon = tram_icon;
                    fragmentManager.beginTransaction().setTransition(TRANSIT_FRAGMENT_FADE).replace(R.id.fragment_container, trolleyFragment).commit();
                    break;
                case "Route":
                    toolbar.setTitle(getResources().getString(R.string.route_name));
                    currentIcon = bus_icon;
                    fragmentManager.beginTransaction().setTransition(TRANSIT_FRAGMENT_FADE).replace(R.id.fragment_container, routeFragment).commit();
                    break;
                case "Suburban":
                    toolbar.setTitle(getResources().getString(R.string.suburban_name));
                    currentIcon = bus_icon;
                    fragmentManager.beginTransaction().setTransition(TRANSIT_FRAGMENT_FADE).replace(R.id.fragment_container, suburbanFragment).commit();
                    break;
                case "Intercity":
                    toolbar.setTitle(getResources().getString(R.string.inter_name));
                    currentIcon = bus_icon;
                    fragmentManager.beginTransaction().setTransition(TRANSIT_FRAGMENT_FADE).replace(R.id.fragment_container, intercityFragment).commit();
                    break;
                case "Train":
                    toolbar.setTitle(getResources().getString(R.string.train_name));
                    currentIcon = train_icon;
                    fragmentManager.beginTransaction().setTransition(TRANSIT_FRAGMENT_FADE).replace(R.id.fragment_container, trainFragment).commit();
                    break;
                case "Exit":
                    finish();
                    moveTaskToBack(true);
                    break;
            }
        }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.popBackStack();
    }
}

