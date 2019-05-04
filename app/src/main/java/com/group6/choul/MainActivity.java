package com.group6.choul;

import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayoutHome;
    private NavigationView navigationViewHome;
    private ActionBarDrawerToggle toggle;
    Dialog getMydialog;
    Button btnhouse, btnroom;
    ViewPager viewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getMydialog = new Dialog(this);
        drawerLayoutHome = findViewById(R.id.drawer_home);
        navigationViewHome = findViewById(R.id.nav_home);
//        viewPager = (ViewPager)findViewById(R.id.slide);
//        slideadapter sladapter = new slideadapter(this);
//        Log.e("Something ", viewPager+"");
//        viewPager.setAdapter(sladapter);
        toggle = new ActionBarDrawerToggle(this,drawerLayoutHome,R.string.opened_menu,R.string.closed_menu);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        loadfragment(new list_fragement());

        navigationViewHome.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                switch (id){
                    case R.id.item_favorite:
                        Intent intent = new Intent(getApplicationContext(), HouseFormActivity.class);
                        startActivity(intent);
                        return true;

                    case R.id.item_chat:
                        Intent intent1 = new Intent(getApplicationContext(), RoomFormActivity.class);
                        startActivity(intent1);
                        return true;
                }
                return false;
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item))
            return true;


        switch (item.getItemId()){
            case R.id.post:
                showPopup();
                return true;
        }


        return super.onOptionsItemSelected(item);
    }

    private void loadfragment(Fragment fragment){
        FragmentManager fm = getFragmentManager();
        FragmentTransaction tr = fm.beginTransaction();
        tr.replace(R.id.container_home,fragment);
        tr.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.post,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void showPopup() {
        getMydialog.setContentView(R.layout.custompostpopup);
        btnhouse=getMydialog.findViewById(R.id.btn_house);
        btnroom=getMydialog.findViewById(R.id.btn_room);

        getMydialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getMydialog.show();
    }
}

