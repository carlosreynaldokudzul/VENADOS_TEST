package com.venadostest.module.menu.view.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import com.example.venadostest.R;
import com.google.android.material.navigation.NavigationView;
import com.venadostest.module.home.fragments.HomeFragment;
import com.venadostest.module.players.activities.PlayersActivity;
import com.venadostest.module.statistics.view.activities.StatisticsActivity;


public class MenuActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawer;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        initialize();
    }
    private void initialize(){

        Toolbar toolbar = findViewById(R.id.toolbar_general);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.icon_menu);
        getSupportActionBar().setTitle("");


        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View hView = navigationView.getHeaderView(0);

        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();



        loadFragment(new HomeFragment());

        navigationView.setCheckedItem(R.id.nav_home);

       /* Fragment fragment = new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).commit();*/


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.notification_menu, menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawer.closeDrawer(GravityCompat.START);
        int idItemSelected = item.getItemId();
        Fragment menuOptionFragment =null;
        Intent intent = null;

        try {
                switch (idItemSelected) {
                    case R.id.nav_home:
                        menuOptionFragment = new HomeFragment();
                        loadFragment(menuOptionFragment);
                        break;
                    case R.id.nav_statistic:
                        //optionIsSelect = true;
                        intent = new Intent(MenuActivity.this, StatisticsActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);

                        break;
                    case R.id.nav_players:
                        //menuOptionFragment = new AscentFragment();
                        intent = new Intent(MenuActivity.this, PlayersActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        break;
                }

            drawer.closeDrawer(GravityCompat.START);

        }catch (Exception e){
            Log.e("ERROR-MENU: ", "Ocurrió un error al iniciar el contenido "+e.getMessage());
            e.printStackTrace();
        }
        return true;
    }
    private void loadFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).commit();
    }
}