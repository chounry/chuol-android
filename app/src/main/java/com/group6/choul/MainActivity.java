package com.group6.choul;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import com.google.android.material.navigation.NavigationView;
import com.group6.choul.fragments.ChatOutFragment;
import com.group6.choul.fragments.HomeFragment;
import com.group6.choul.fragments.SavedPostFragment;
import com.group6.choul.fragments.SettingFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawerLayoutHome;
    private NavigationView navigationViewHome;
    private ActionBarDrawerToggle toggle;
    Dialog getMydialog;
    Button btnHouse, btnRoom;

    private Toolbar toolBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getMydialog = new Dialog(this);
        drawerLayoutHome = findViewById(R.id.drawer_home);
        navigationViewHome = findViewById(R.id.nav_home);
        toolBar = findViewById(R.id.toolbar);


        setSupportActionBar(toolBar);
        toggle = new ActionBarDrawerToggle(this,drawerLayoutHome,toolBar,R.string.opened_menu,R.string.closed_menu);
        drawerLayoutHome.addDrawerListener(toggle);
        toggle.syncState();
        navigationViewHome.setNavigationItemSelectedListener(this);
        loadFragment(new HomeFragment());


        //   handle tap -------------------->

//        loadFragment(new HouseListHomeFragment());
//        navigationViewHome.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//                int id = menuItem.getItemId();
//                switch (id){
//                    case R.id.item_home:
//                        loadFragment(new HouseListHomeFragment());
//                        return true;
//                    case R.id.item_saved:
//                        loadFragment(new SavedPostFragment());
//                        return true;
//                    case R.id.item_chat:
//                        loadFragment(new ChatOutFragment());
//                        return true;
//                    case R.id.item_setting:
//                        loadFragment(new SettingFragment());
//                        return true;
//                }
//                return false;
//            }
//        });
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item))
            return true;

        switch (item.getItemId()) {
            case R.id.post:
                showPopup();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void loadFragment(Fragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction tr = fm.beginTransaction();
        tr.replace(R.id.container_home,fragment);
        tr.commit();
        drawerLayoutHome.closeDrawers();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.post,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void showPopup() {
        getMydialog.setContentView(R.layout.custom_post_pop_up);
        btnHouse = getMydialog.findViewById(R.id.btn_house);
        btnRoom = getMydialog.findViewById(R.id.btn_room);

        btnHouse.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HouseFormActivity.class);
                startActivity(intent);
            }
        });
        btnRoom.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), RoomFormActivity.class);
                startActivity(intent);
            }
        });

        getMydialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getMydialog.show();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.item_home) {
            loadFragment(new HomeFragment());
            return true;
        } else if (id == R.id.item_chat) {
            loadFragment(new ChatOutFragment());
            return true;
        } else if (id == R.id.item_saved) {
            loadFragment(new SavedPostFragment());
            return true;
        } else if (id == R.id.item_setting) {
            loadFragment(new SettingFragment());
            return true;
        }

        DrawerLayout drawer = findViewById(R.id.drawer_home);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}

