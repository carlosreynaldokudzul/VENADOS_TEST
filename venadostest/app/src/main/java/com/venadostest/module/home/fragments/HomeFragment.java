package com.venadostest.module.home.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.venadostest.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.venadostest.module.menu.models.GameModel;
import com.venadostest.module.menu.view.fragments.AscentFragment;
import com.venadostest.module.menu.view.fragments.GamesFragment;
import com.venadostest.module.menu.view.fragments.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private TabLayout tabLayout;
    private TabItem tabCoupMX, tabAscentMX;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private List<GameModel> lisGamesModel = new ArrayList<>();

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  = inflater.inflate(R.layout.fragment_home, container, false);
        setUpView(view);
        setUpViewPager();
        return view;
    }

    private void setUpView(View view){
        //tabLayout = view.findViewById(R.id.tabLayoutHomeFragment);
        viewPager = view.findViewById(R.id.viewpager);
        tabLayout = view.findViewById(R.id.tabLayoutHomeFragment);

        tabCoupMX = view.findViewById(R.id.tab_coup_mx);
        tabAscentMX = view.findViewById(R.id.tab_ascent_mx);

        viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager(), ViewPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, tabLayout.getTabCount(), lisGamesModel);
        viewPager.setAdapter(viewPagerAdapter);

    }
    private void setUpViewPager(){
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}