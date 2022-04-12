package com.example.navigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.navigationdrawer.fragment.BorderLayout;
import com.example.navigationdrawer.fragment.FoodBank;
import com.example.navigationdrawer.fragment.FoodBeverage;
import com.example.navigationdrawer.fragment.RestaurantMenu;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * make android use toolbar as aciton bar
         */
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.draw_layout);
        /**
         * To customize the drawable icon.
         * drawerLayout instance can be used
         */

        /**
         * To create a toggle animation.
         * ActionBarDrawerToggle is used.
         */
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_draw_open, R.string.navigation_draw_close);
        /**
         * Add DrawListner to the actionBarDrawerToggle.
         */
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        /**
         *  GravityCompat.END
         *  Will close the Drawer from the Righr Side
         */
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.border:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new BorderLayout()).commit();
                navigationView.setCheckedItem(R.id.border);
                break;
            case R.id.food_beverage:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FoodBeverage()).commit();
                navigationView.setCheckedItem(R.id.food_beverage);
                break;
            case R.id.foodBank:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FoodBank()).commit();
                navigationView.setCheckedItem(R.id.foodBank);
                break;
            case R.id.restuarant:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new RestaurantMenu()).commit();
                navigationView.setCheckedItem(R.id.restuarant);
                break;
            case R.id.laptop:
                Toast.makeText(this, "LapTop", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mobile:
                Toast.makeText(this, "Mobile", Toast.LENGTH_SHORT).show();
                break;
        }
        /**
         * To close the Drawer layout after Fragment is opened.
         */
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}