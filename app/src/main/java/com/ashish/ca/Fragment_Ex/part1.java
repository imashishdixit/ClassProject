package com.ashish.ca.Fragment_Ex;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.ashish.ca.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class part1 extends Fragment {

    public part1() {
        // Required empty public constructor
    }
    String [] androidOs=new String[] {"Cupcake","Donut","Eclair","Froyo","GingerBread","HoneyComb","Ice Cream","JellyBean","KitKat","Lollipop","Marshmellow","Nougat","Oreo"};
    ListView lv;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View root=inflater.inflate(R.layout.listview,container,false);
       lv=root.findViewById(R.id.list_view);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,androidOs);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                part2 obj=(part2) getFragmentManager().findFragmentById(R.id.fragment2);
                obj.change("Android OS: "+androidOs[position]);
                lv.setSelector(android.R.color.holo_blue_dark);

            }
        });
        return root;
    }
}
