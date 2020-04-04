package com.ashish.ca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ashish.ca.Custom_View.Custom_Main;
import com.ashish.ca.Fragment_Ex.Frag_Main;
import com.ashish.ca.GallaryApp.Gallary_Main;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v){
        int id=v.getId();
        Intent intent;
        switch (id){
            case R.id.Gallary_App:
                intent=new Intent(MainActivity.this, Gallary_Main.class);
                startActivity(intent);
                break;
            case R.id.Custom_App:
                intent=new Intent(MainActivity.this, Custom_Main.class);
                startActivity(intent);
                break;
            case R.id.Fragment_View:
                intent=new Intent(MainActivity.this, Frag_Main.class);
                startActivity(intent);
                break;

        }
    }
}
