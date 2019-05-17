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

public class roomdetailactivity extends AppCompatActivity implements OnMapReadyCallback {
    ViewPager viewPager;
    private FrameLayout map;

    private GoogleMap mMap;
    private relatedadapter adapter;
    private List<realatedmodel> modelList;
    private RecyclerView recyclerViewHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.roomdetail);

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
            modelList.add(new realatedmodel("Room 1 bed","$50","https://s-ec.bstatic.com/images/hotel/max1024x768/731/73118462.jpg" ));
            modelList.add(new realatedmodel("Room 2 bed","$60","https://secure.cdn1.wdpromedia.com/resize/mwImage/1/560/216/75/dam/wdpro-assets/aulani/room-offers/resort-room/nbr-standard-view-1-16x9.jpg?1540508656347" ));
            modelList.add(new realatedmodel("Room 2 bed","$100","https://d2ile4x3f22snf.cloudfront.net/wp-content/uploads/sites/161/2017/10/01091859/chateau-tongariro-our-rooms-heritage-3-bed-family-style-image.jpg" ));

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

