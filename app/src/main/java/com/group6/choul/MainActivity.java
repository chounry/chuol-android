package com.group6.choul;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.group6.choul.adapters.PageAdapter;
import com.group6.choul.fragments.ChatOutFragment;
import com.group6.choul.fragments.HouseListHomeFragment;
import com.group6.choul.fragments.SavedPostFragment;
import com.group6.choul.fragments.SettingFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawerLayoutHome;
    private NavigationView navigationViewHome;
    private ActionBarDrawerToggle toggle;
    Dialog getMydialog;
    Button btnhouse, btnroom;

    private PageAdapter tab_adapter;

    private TabLayout tabLayout;
    private Toolbar toolBar;
    private ViewPager tabPageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getMydialog = new Dialog(this);
        drawerLayoutHome = findViewById(R.id.drawer_home);
        navigationViewHome = findViewById(R.id.nav_home);
        toolBar = findViewById(R.id.toolbar);
        tabPageView = findViewById(R.id.viewPage_home);
        tabLayout = findViewById(R.id.tab_h);

        setSupportActionBar(toolBar);
        toggle = new ActionBarDrawerToggle(this,drawerLayoutHome,toolBar,R.string.opened_menu,R.string.closed_menu);
        drawerLayoutHome.addDrawerListener(toggle);
        toggle.syncState();
        navigationViewHome.setNavigationItemSelectedListener(this);

//      <------------   handle tap
        tab_adapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        tabPageView.setAdapter(tab_adapter);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tabPageView.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

        });

        tabPageView.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

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


        switch (item.getItemId()){
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
        getMydialog.setContentView(R.layout.custompostpopup);
        btnhouse=getMydialog.findViewById(R.id.btn_house);
        btnroom=getMydialog.findViewById(R.id.btn_room);

        getMydialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getMydialog.show();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.item_home) {
            loadFragment(new HouseListHomeFragment());
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

