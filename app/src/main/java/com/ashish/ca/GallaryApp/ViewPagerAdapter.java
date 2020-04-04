package com.ashish.ca.GallaryApp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> fragments=new ArrayList<>();
    ArrayList<String> strings=new ArrayList<>();
    public ViewPagerAdapter(FragmentManager fm){
        super(fm);
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new FragmentOne();

            case 1:
                return new FragmentTwo();

            case 2:
                return new FragmentThree();

            case 3:
                return new FragmentFour();

            case 4:
                return new FragmentFive();
            case 5:
                return new FragmentSix();
            case 6:
                return new FragmentSeven();
            case 7:
                return new FragmentEight();
            default:
                return null;

        }
        //return null; //isko hatana hai
    }

    @Override
    public int getCount() {
        return fragments.size();

    }
    public void add(Fragment fr,String str){
        fragments.add(fr);
        strings.add(str);

    }
    public CharSequence getPageTitle(int position){
        return strings.get(position);
    }
}
