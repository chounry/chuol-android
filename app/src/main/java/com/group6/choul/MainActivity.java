package com.group6.choul;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import android.os.Bundle;

import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.material.navigation.NavigationView;
import com.group6.choul.fragments.ChatOutFragment;
import com.group6.choul.fragments.HomeFragment;
import com.group6.choul.fragments.SavedPostFragment;
import com.group6.choul.fragments.SettingFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawerLayoutHome;
    private NavigationView navigationViewHome;
    private ActionBarDrawerToggle toggle;
    private Dialog formSelectDialog,loginDialog;
    private Button btnHouseForm, btnRoomForm;
    private Toolbar toolBar;
    private TextView welcomeTv;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        overridePendingTransition(0, 0);
        formSelectDialog = new Dialog(this);
        loginDialog = new Dialog(this);
        drawerLayoutHome = findViewById(R.id.drawer_home);
        navigationViewHome = findViewById(R.id.nav_home);
        toolBar = findViewById(R.id.toolbar);

        setSupportActionBar(toolBar);

        toggle = new ActionBarDrawerToggle(this,drawerLayoutHome,toolBar,R.string.opened_menu,R.string.closed_menu);
        drawerLayoutHome.addDrawerListener(toggle);
        toggle.syncState();
        navigationViewHome.setNavigationItemSelectedListener(this);

        loadFragment(new HomeFragment()); // init fragment

    }





    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item))
            return true;

        switch (item.getItemId()) {
            case R.id.post:
                showFormSelectPopup();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void loadFragment(Fragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction tr = fm.beginTransaction();
        tr.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_right);
        tr.replace(R.id.container_home,fragment);
        tr.commit();
        drawerLayoutHome.closeDrawers();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.post,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void showFormSelectPopup() {
        formSelectDialog.setContentView(R.layout.custom_post_pop_up);
        btnHouseForm = formSelectDialog.findViewById(R.id.btn_house);
        btnRoomForm = formSelectDialog.findViewById(R.id.btn_room);

        btnHouseForm.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HouseFormActivity.class);
                startActivity(intent);
            }
        });
        btnRoomForm.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), RoomFormActivity.class);
                startActivity(intent);
            }
        });

        formSelectDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        formSelectDialog.show();
    }

    public void showLoginPopUp() {
        loginDialog.setContentView(R.layout.login);

        loginDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        loginDialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        loginDialog.getWindow().setGravity(Gravity.TOP);
        loginDialog.show();
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
            showLoginPopUp();
            drawerLayoutHome.closeDrawers();
//            loadFragment(new SettingFragment());
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

