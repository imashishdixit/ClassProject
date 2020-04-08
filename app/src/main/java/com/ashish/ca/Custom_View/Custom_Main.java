package com.ashish.ca.Custom_View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ashish.ca.CustomEditText;
import com.ashish.ca.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;


public class Custom_Main extends AppCompatActivity {

    private String data,getdata = "";
    private CustomEditText edittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom__main);



        checkPermission();

        edittext = findViewById(R.id.edit_text_2);

        edittext.requestFocus();

        Button save = findViewById(R.id.save_data);
        save.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onClick(View v) {
                data = Objects.requireNonNull(edittext.getText()).toString().trim();
                if (data.isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Field is Empty...",Toast.LENGTH_SHORT).show();
                }
                else {
                    try {
                        File root = new File(Environment.getExternalStorageDirectory(), "Data");
                        if (!root.exists()) {
                            root.mkdirs();
                        }
                        File gpxfile = new File(root, "Record.txt");
                        FileWriter writer = new FileWriter(gpxfile);
                        writer.append(data);
                        writer.flush();
                        writer.close();
                        Toast.makeText(getApplicationContext(), "Data Saved Successfully...", Toast.LENGTH_SHORT).show();
                        edittext.setText("");
                        edittext.hideButton();
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Button show = findViewById(R.id.show_data);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String line;
                    String path = Environment.getExternalStorageDirectory()+"/Data/Record.txt";
                    FileReader fileReader = new FileReader(new File(path));
                    StringBuilder builder = new StringBuilder();
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    while ((line = bufferedReader.readLine()) != null) {
                        builder.append(line);
                        builder.append("\n");
                    }
                    getdata = builder.toString();
                    if (getdata.isEmpty()) {
                        Toast.makeText(getApplicationContext(),"File is Empty...",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(getApplicationContext(),getdata,Toast.LENGTH_SHORT).show();
                    }
                }
                catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @SuppressLint("InlinedApi")
    private void checkPermission() {

        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(Custom_Main.this,new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE},131);
        }
    }

    @SuppressLint("InlinedApi")
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 131) {
            if (grantResults[0]!=PackageManager.PERMISSION_GRANTED || grantResults[1]!=PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(Custom_Main.this,new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE},131);
            }
        }
    }
}

