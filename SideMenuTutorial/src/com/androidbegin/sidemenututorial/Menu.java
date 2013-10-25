package com.androidbegin.sidemenututorial;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

public class Menu extends Activity{
	
	@Override
	 public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	       
	    ScrollView scroll = new ScrollView(this);
	    RelativeLayout myLayout = new RelativeLayout(this); 
        
	    myLayout.setBackground(getResources().getDrawable(R.drawable.back_a));
	    
	    Button bogus = null;
	    Button A = addButtonToLayout(0,myLayout, bogus);
	    Button B = addButtonToLayout(1,myLayout, A);
	    Button C = addButtonToLayout(2,myLayout, B);
	    Button D = addButtonToLayout(3,myLayout, C);
	    Button E = addButtonToLayout(4,myLayout, D);
	    Button F = addButtonToLayout(5,myLayout, E);
	    Button G = addButtonToLayout(6,myLayout, F);
	    Button H = addButtonToLayout(7,myLayout, G);
	    scroll.addView(myLayout);
	    setContentView(scroll);
	}	
	
	public Button addButtonToLayout(int id, ViewGroup layout, Button previous)
	{
		Button myButton = new Button(this);
	    myButton.setId(id);
	    myButton.setText("Hello" + id);
		myButton.setBackground(getResources().getDrawable(R.drawable.login_clicked));
		myButton.setWidth(250);
		myButton.setHeight(100);
		myButton.setClickable(true);
		myButton.setOnClickListener(new Button.OnClickListener() {
		       	
			@Override
			public void onClick(View arg0) {
			// TODO Auto-generated method stub
				 
			}
	    });
        RelativeLayout.LayoutParams buttonParam = 
                new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT, 
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
        
        if( id == 0)
        {
            buttonParam.addRule(RelativeLayout.CENTER_HORIZONTAL);
            buttonParam.addRule(RelativeLayout.CENTER_VERTICAL);
        }
        else
        {
            buttonParam.addRule(RelativeLayout.BELOW, previous.getId());
            buttonParam.addRule(RelativeLayout.CENTER_HORIZONTAL);
            buttonParam.setMargins(0, 80, 0, 40);
        }
        
        if( id != 0 )
        	layout.addView(myButton, buttonParam);
        
        return myButton;
	}
	
}