package com.ashish.ca.GallaryApp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TableLayout;

import com.ashish.ca.R;

public class Gallary_Main extends AppCompatActivity {
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallary__main);
        viewPager=findViewById(R.id.viewPager);

        ViewPagerAdapter adapter=new ViewPagerAdapter(getSupportFragmentManager());
        adapter.add(new FragmentOne(),"One");
        adapter.add(new FragmentTwo(),"Two");
        adapter.add(new FragmentThree(),"Three");
        adapter.add(new FragmentFour(),"Four");
        adapter.add(new FragmentFive(),"Five");
        adapter.add(new FragmentSix(),"Six");
        adapter.add(new FragmentSeven(),"Seven");
        adapter.add(new FragmentEight(),"Eight");
        viewPager.setAdapter(adapter);



    }
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.option_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.select_from_gallary:

                return true;


            default:
            return super.onOptionsItemSelected(item);
        }
    }
}
