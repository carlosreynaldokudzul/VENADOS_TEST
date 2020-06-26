package com.venadostest.module.menu.view.fragments;



import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


import com.venadostest.module.menu.models.GameModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author crkd
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    private int tabsNumber;
    private List<GameModel> listGamesModel = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fragmentManager, int behavior, int tabs, List<GameModel> listGamesModel){
        super(fragmentManager, behavior);
        this.tabsNumber = tabs;
        this.listGamesModel = listGamesModel;

    }


    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new GamesFragment(listGamesModel);
            case 1:
                return new AscentFragment(listGamesModel);

            default: return  null;
        }
    }
    @Override
    public int getCount() {
        //return tabFragments.size();
        return tabsNumber;
    }
    /*
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentsTitles.get(position);
    }

    public void addFragment(Fragment fragment, String tittle){
        tabFragments.add(fragment);
        fragmentsTitles.add(tittle);
    }*/
}
