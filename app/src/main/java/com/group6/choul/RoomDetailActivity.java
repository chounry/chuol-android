package com.group6.choul;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.group6.choul.adapters.SlideAdapter;
import com.group6.choul.adapters.RelatedAdapter;
import com.group6.choul.models.RelatedModel;

import java.util.ArrayList;
import java.util.List;

public class RoomDetailActivity extends AppCompatActivity implements OnMapReadyCallback {
    ViewPager viewPager;
    private FrameLayout map;

    private GoogleMap mMap;
    private RelatedAdapter adapter;
    private List<RelatedModel> modelList;
    private RecyclerView recyclerViewHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_detail);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        viewPager = findViewById(R.id.slide);
        recyclerViewHome = findViewById(R.id.related_recycler_home);


        SlideAdapter sladapter = new SlideAdapter(getApplicationContext());

        viewPager.setAdapter(sladapter);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

//        mItemSelected = findViewById(R.id.tvItemSelected);
        map = findViewById(R.id.map);

        modelList = new ArrayList<>();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        recyclerViewHome.setHasFixedSize(true);
        recyclerViewHome.setLayoutManager(layoutManager);

        for(int i = 0;i < 10;i++){
            modelList.add(new RelatedModel("Room 1 bed","$50","https://s-ec.bstatic.com/images/hotel/max1024x768/731/73118462.jpg" ));
            modelList.add(new RelatedModel("Room 2 bed","$60","https://secure.cdn1.wdpromedia.com/resize/mwImage/1/560/216/75/dam/wdpro-assets/aulani/room-offers/resort-room/nbr-standard-view-1-16x9.jpg?1540508656347" ));
            modelList.add(new RelatedModel("Room 2 bed","$100","https://d2ile4x3f22snf.cloudfront.net/wp-content/uploads/sites/161/2017/10/01091859/chateau-tongariro-our-rooms-heritage-3-bed-family-style-image.jpg" ));

        }

        adapter = new RelatedAdapter(modelList);
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

