package com.group6.choul;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;


import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.group6.choul.adapters.SlideAdapter;
import com.group6.choul.adapters.RelatedAdapter;
import com.group6.choul.models.ImageModel;
import com.group6.choul.models.RelatedModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class HouseDetailActivity extends AppCompatActivity implements OnMapReadyCallback {
    ViewPager viewPager;
    private FrameLayout map;

    private GoogleMap mMap;
    private RelatedAdapter adapter;
    private List<RelatedModel> modelList;
    private RecyclerView recyclerViewHome;
    private String url = "http://172.23.12.108:8000/api/houses/get_detail";
    private ArrayList<ImageModel> images;
    private String estate_id;
    private double lat,lng;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_detail);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        images = new ArrayList<>();
        viewPager = findViewById(R.id.slide);
        recyclerViewHome = findViewById(R.id.related_recycler_home);
        estate_id = getIntent().getStringExtra("ESTATE_ID");


        SlideAdapter sladapter = new SlideAdapter(getApplicationContext(),images);

        viewPager.setAdapter(sladapter);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

//        mItemSelected = findViewById(R.id.tvItemSelected);
        map = findViewById(R.id.map);

        modelList = new ArrayList<>();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        recyclerViewHome.setHasFixedSize(true);
        recyclerViewHome.setLayoutManager(layoutManager);

        adapter = new RelatedAdapter(modelList);
        recyclerViewHome.setAdapter(adapter);

        getData(url);

    }
    private  void setInfo(String title,String for_sale_status,String price,String description,String street,String city,String bathroom,String bedroom,String floor,String size,String email,String phone,String phone_option,String currency){
        TextView description_tv,street_tv,city_tv,email_tv,phone_tv,title_tv,price_tv,for_sale_status_tv,bedroom_tv,bathroom_tv,floor_tv,size_tv;

        description_tv = findViewById(R.id.room_description);
        street_tv = findViewById(R.id.room_street);
        city_tv = findViewById(R.id.room_city);
        email_tv = findViewById(R.id.room_email);
        phone_tv = findViewById(R.id.room_phone);
        title_tv = findViewById(R.id.room_title);
        price_tv = findViewById(R.id.room_price);
        for_sale_status_tv =findViewById(R.id.for_sale_rent);
        bathroom_tv = findViewById(R.id.bathroom);
        bedroom_tv = findViewById(R.id.bedroom);
        floor_tv = findViewById(R.id.floor);
        size_tv = findViewById(R.id.house_size);



        title_tv.setText(title);
        description_tv.setText(description);
        email_tv.setText(email);
        phone_tv.setText(phone  + "/" + phone_option);
        street_tv.setText(street);
        city_tv.setText(city);
        for_sale_status_tv.setText(for_sale_status);
        bathroom_tv.setText(bathroom);
        bedroom_tv.setText(bedroom);
        floor_tv.setText(floor);
        size_tv.setText(size);


        // image slide
        SlideAdapter slAdapter = new SlideAdapter(getApplicationContext(), images);
        viewPager.setAdapter(slAdapter);

        if (currency.equals("Dollar")){
            price_tv.setText(price + "$");
        }
        else{
            price_tv.setText(price + "R");
        }



    }
    private void getData(String url) {
        try {
            String url_for_img = "http://172.23.12.108:8000";
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            JSONObject jsonBody = new JSONObject();
            jsonBody.put("estate_id", estate_id);

            final String requestBody = jsonBody.toString();
            StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject responeJson = new JSONObject(response);
                        String estate_id,title,for_sale_status,description,street,city,bathroom,bedroom,floor,size,email,phone,price,phone_option,currency;
                        Log.e("onResponse: ",responeJson.getJSONArray("img") + "");
                        JSONArray img_arr = responeJson.getJSONArray("img");
                        for (int i = 0; i< img_arr.length();i++){

                            ImageModel img = new ImageModel(url_for_img +img_arr.get(i).toString());
                            images.add(img);
                        }
                        estate_id = responeJson.getString("estate_id");
                        title = responeJson.getString("title");
                        for_sale_status = responeJson.getString("for_sale_status");
                        description = responeJson.getString("description");
                        street = responeJson.getString("address");
                        city = responeJson.getString("location");
                        email = responeJson.getString("email");
                        phone = responeJson.getString("phone");
                        price = responeJson.getString("price");
                        phone_option = responeJson.getString ("phone_option");
                        currency = responeJson.getString("currency");
                        lat = responeJson.getDouble("lat");
                        lng = responeJson.getDouble("lng");
                        bathroom = responeJson.getString("bathroom");
                        bedroom =responeJson.getString("bedroom");
                        floor =responeJson.getString("floor");
                        size = responeJson.getString("house_size");


                        setInfo(title,for_sale_status,price,description,street,city,bathroom,bedroom,floor,size,email,phone,phone_option,currency);
                    } catch (Exception e) {
                        Log.e("Json Error", e.toString());
                    }

                }
            },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e("MYError", error.toString());
                        }
                    }) {
                @Override
                public String getBodyContentType() {
                    return "application/json; charset=utf-8";
                }


                @Override
                public byte[] getBody() throws AuthFailureError {
                    try {
                        return requestBody == null ? null : requestBody.getBytes("utf-8");
                    } catch (UnsupportedEncodingException uee) {
                        VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", requestBody, "utf-8");
                        return null;
                    }
                }
            };
            requestQueue.add(request);
        }catch (Exception e){

        }

    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney, Australia, and move the camera.
        LatLng sydney = new LatLng(lat, lng);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Phnom Penh"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

}

