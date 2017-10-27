package com.example.android.twitterapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Krit17 on 21-10-2017.
 */

public class CustomFragmentAdapter extends FragmentPagerAdapter {
    public CustomFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0){
          return new Home_Fragment();
        }else if(position==1){
            return new Search_Fragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0){
           return "Home_Fragment";
        }else if(position==1) {
            return "Search";
        }
        return super.getPageTitle(position);
    }
}
