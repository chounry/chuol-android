package com.group6.choul;

import android.os.Bundle;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class housedetailactivity extends AppCompatActivity implements OnMapReadyCallback {
    ViewPager viewPager;
    private FrameLayout map;

    private GoogleMap mMap;
    private relatedadapter adapter;
    private List<realatedmodel> modelList;
    private RecyclerView recyclerViewHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.housedetail);

        viewPager = findViewById(R.id.slide);
        recyclerViewHome = findViewById(R.id.related_recycler_home);


        slideadapter sladapter = new slideadapter(getApplicationContext());

        viewPager.setAdapter(sladapter);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

//        mItemSelected = findViewById(R.id.tvItemSelected);
        map = findViewById(R.id.map);

        modelList = new ArrayList<>();
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        recyclerViewHome.setHasFixedSize(true);
        recyclerViewHome.setLayoutManager(layoutManager);

        for(int i = 0;i < 10;i++){
            modelList.add(new realatedmodel("Luxury House","$20000","https://www.iconichouses.org/foto/houses/duldeck.jpg" ));
            modelList.add(new realatedmodel("Luxury House","$20000","https://static1.squarespace.com/static/5729cc3701dbae1046dcf042/58a0ec586b8f5b048e0528bd/58a0ec8ec534a53dfb4b4520/1486941328065/POINT112E_1.jpg?format=1000w" ));
            modelList.add(new realatedmodel("Luxury House","$20000","https://images.adsttc.com/media/images/59a4/c624/b22e/389d/3e00/02a3/newsletter/MHA.JR_201708_038.jpg?1503970808" ));

        }

        adapter = new relatedadapter(modelList);
        recyclerViewHome.setAdapter(adapter);

    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney, Australia, and move the camera.
        LatLng sydney = new LatLng(11.585439, 104.916806);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Phnom Penh"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

}

