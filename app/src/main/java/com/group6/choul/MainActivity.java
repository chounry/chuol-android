package com.group6.choul;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayoutHome;
    private NavigationView navigationViewHome;
    private ActionBarDrawerToggle toggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayoutHome = findViewById(R.id.drawer_home);
        navigationViewHome = findViewById(R.id.nav_home);
        toggle = new ActionBarDrawerToggle(this,drawerLayoutHome,R.string.opened_menu,R.string.closed_menu);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        loadfragment(new list_fragement());
        navigationViewHome.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                switch (id){
                    case R.id.item_home:
                        loadfragment(new list_fragement());
                        drawerLayoutHome.closeDrawers();
                        return true;
                    case R.id.item_favorite:
                        loadfragment(new setting());
                        drawerLayoutHome.closeDrawers();
                        return true;
                    case R.id.item_chat:
                        loadfragment(new PersonalInfo());
                        drawerLayoutHome.closeDrawers();
                        return true;
                    case R.id.item_setting:
                        loadfragment(new PersonalInfo());
                        drawerLayoutHome.closeDrawers();
                        return true;
                    case R.id.item_aboutus:
                        loadfragment(new PersonalInfo());
                        drawerLayoutHome.closeDrawers();
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
}

