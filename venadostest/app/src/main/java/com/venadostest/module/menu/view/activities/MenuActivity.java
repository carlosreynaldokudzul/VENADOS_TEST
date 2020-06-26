package com.venadostest.module.menu.view.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import com.example.venadostest.R;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.venadostest.module.home.fragments.HomeFragment;
import com.venadostest.module.menu.view.fragments.AscentFragment;
import com.venadostest.module.menu.view.fragments.GamesFragment;
import com.venadostest.module.menu.view.fragments.ViewPagerAdapter;

public class MenuActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawer;
    ActionBarDrawerToggle toggle;

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabItem tabCoupMX, tabAscentMX;
    private ViewPagerAdapter viewPagerAdapter;



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
        //getMenuInflater().inflate(R.menu.activity_menu_drawer, menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawer.closeDrawer(GravityCompat.START);
        int idItemSelected = item.getItemId();
        Fragment menuOptionFragment =null;
        try {
                switch (idItemSelected) {
                    case R.id.nav_home:
                        menuOptionFragment = new HomeFragment();
                        break;
                    case R.id.nav_statistic:
                        //optionIsSelect = true;
                        break;
                    case R.id.nav_players:
                        //menuOptionFragment = new AscentFragment();
                        break;
                }
            if (menuOptionFragment ==  null){
                throw  new Exception("Error al crear el fragment");
            }

            //getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,menuOptionFragment).commit();
            //drawer.getItem(item.getItemId()).setEnabled(false);
            loadFragment(menuOptionFragment);
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