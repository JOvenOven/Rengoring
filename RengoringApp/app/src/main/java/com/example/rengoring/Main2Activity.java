package com.example.rengoring;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
//import android.widget.Toolbar;

public class Main2Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle= new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new agregarresiduoFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_agregarresiduos);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_agregarresiduos:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new agregarresiduoFragment()).commit();
                break;
            case R.id.nav_historial:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new historialFragment()).commit();
                break;
            case R.id.nav_acercade:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new acercadeFragment()).commit();
                break;
            case R.id.nav_maps:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new mapsFragment()).commit();
                break;
            case R.id.nav_cerrarsesion:
                startActivity(new Intent(Main2Activity.this, login.class));
                finish();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
        super.onBackPressed();
    }
}
