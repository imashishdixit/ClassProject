package com.ashish.ca.Fragment_Ex;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ashish.ca.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class part2 extends Fragment {
    TextView tv;
    public part2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.textview,container,false);
        tv=(TextView)root.findViewById(R.id.text_view);


        return root;
    }
    public void change(String str){
        tv.setText(str);

    }
}
