package com.ashish.ca.GallaryApp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TableLayout;

import com.ashish.ca.R;

import java.net.URI;

public class Gallary_Main extends AppCompatActivity {
    ViewPager viewPager;
    public URI uri;
    SharedPreferences sp;
    FragmentOne f1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallary__main);
        viewPager=findViewById(R.id.viewPager);
        sp=getSharedPreferences("student",MODE_PRIVATE);
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
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(i, 101);
                return true;


            default:
            return super.onOptionsItemSelected(item);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101 && resultCode == RESULT_OK && data!=null) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();


            SharedPreferences.Editor edit=sp.edit();
            edit.putString("imagepath",picturePath);
            Log.d("msg", "onActivityResult: "+picturePath);
            edit.commit();




        }
    }

}
