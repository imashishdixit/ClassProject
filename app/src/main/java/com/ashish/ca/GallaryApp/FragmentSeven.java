package com.ashish.ca.GallaryApp;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ashish.ca.R;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentSeven#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentSeven extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    SharedPreferences sp;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Bitmap bitmap;
    public FragmentSeven() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentSeven.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentSeven newInstance(String param1, String param2) {
        FragmentSeven fragment = new FragmentSeven();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View root=inflater.inflate(R.layout.fragment_seven, container, false);
        sp = this.getActivity().getSharedPreferences("student", MODE_PRIVATE);
        String savedPicturePath = sp.getString("imagepath","null");
        if(!savedPicturePath.equals("null")){

            ImageView iv;
            bitmap = BitmapFactory.decodeFile(savedPicturePath);
            Drawable d = new BitmapDrawable(getResources(),bitmap);
            iv = root.findViewById(R.id.imageView);
            iv.setImageDrawable(d);


        }
        return root;
    }
}
