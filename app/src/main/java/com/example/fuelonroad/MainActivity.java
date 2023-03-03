package com.example.fuelonroad;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity {
    private AppBarConfiguration mAppBarConfiguration;
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getWindow().setStatusBarColor(Color.rgb(0,32,67));
//        getWindow().setStatusBarColor(Color.TRANSPARENT);
        setContentView(R.layout.activity_main);
        drawer = findViewById(R.id.drawer_layout);
        lockDrawer();
        drawer.setBackgroundColor(Color.BLUE);
        mAppBarConfiguration = new AppBarConfiguration.Builder(R.id.vehiculosFragment, R.id.profileFragment, R.id.incidenciasFragment)
                .setOpenableLayout(drawer)
                .build();
        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem item) {
                        // Handle navigation item clicks here
                        int id = item.getItemId();
                        switch (id) {
                            case R.id.profileFragment:
                                NavController navController = Navigation.findNavController(MainActivity.this, R.id.nav_host_fragment);
                                navController.navigate(R.id.actualizarPerfilFragment);
                                break;
                            case R.id.vehicleFragment:
                                navController = Navigation.findNavController(MainActivity.this, R.id.nav_host_fragment);
                                navController.navigate(R.id.vehiculosFragment);
                                break;
                            case R.id.inciFragment:
                                navController = Navigation.findNavController(MainActivity.this, R.id.nav_host_fragment);
                                navController.navigate(R.id.incidenciasFragment);
                                break;
                            case R.id.routeFragment:
                                navController = Navigation.findNavController(MainActivity.this, R.id.nav_host_fragment);
                                navController.navigate(R.id.mapView);
                                break;
                        }
                        // Set the item as checked to highlight it
                        item.setChecked(true);
                        // Close the drawer
                        DrawerLayout drawer = findViewById(R.id.drawer_layout);
                        drawer.closeDrawer(GravityCompat.START);
                        return true;
                    }
                });
        navigationView.getMenu().findItem(R.id.profileFragment).setChecked(true);
    }
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
    public void lockDrawer(){
        drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
    }
    public void unlockDrawer(){
        drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
    }

}