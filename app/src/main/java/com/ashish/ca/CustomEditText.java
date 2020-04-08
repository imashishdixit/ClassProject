package com.ashish.ca;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.res.ResourcesCompat;

import java.util.Objects;

public class CustomEditText extends AppCompatEditText {
    Drawable clrbtn,clrbtn1;

    public CustomEditText(Context context) {
        super(context);
        init();
    }

    public CustomEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public void init(){
        clrbtn= ResourcesCompat.getDrawable(getResources(),R.drawable.cross_black,null);
        clrbtn1=ResourcesCompat.getDrawable(getResources(),R.drawable.cross_white,null);
        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                showButton();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                float clrbtnStart;
                boolean isClicked=false;
                clrbtnStart=getWidth()-getPaddingEnd()-clrbtn.getIntrinsicWidth();
                if(event.getX()>clrbtnStart){
                    isClicked=true;
                }
                if(isClicked){
                    switch (event.getAction()){
                        case MotionEvent.ACTION_DOWN:
                            Objects.requireNonNull(getText()).clear();
                        case MotionEvent.ACTION_UP:
                            hideButton();
                    }
                }
                return false;
            }
        });
    }
   public  void showButton(){
        setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,clrbtn,null);

    }
    public void hideButton(){
        setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,clrbtn1,null);
    }
}
