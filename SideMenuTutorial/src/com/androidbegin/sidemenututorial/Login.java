package com.androidbegin.sidemenututorial;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class Login extends Activity{
	
	ProgressDialog progDialog;
	String data = "";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Get the view from drawer_main.xml
		setContentView(R.layout.login);
	}

	
	public void onLoginClicked(View v) {

		final FetchDatabase getdb = new FetchDatabase();
		progDialog = ProgressDialog.show(this, "Information Download",
	            "Loading Menus, Plates, Deserts, Drinks...", true);
		progDialog.setCancelable(true);
		
		
	    new Thread() {
	        public void run() {
	            try {
	                data = getdb.getDataFromDB();
	                System.out.println(data);
	                         
	                runOnUiThread(new Runnable() {
	                             
	                	@Override
	                    public void run() {
	                        ArrayList<Users> users = parseJSON(data);
	                    }
	                });

	            	Intent intent = new Intent(Login.this, Menu.class);
	            	startActivity(intent);  	
	                
	            } catch (Exception e) {
	        		Toast.makeText(Login.this, "Loading failed. Check internet connections", 0).show();
	            }
	            progDialog.dismiss();
	        }
	    }.start();
	}
	
	public ArrayList<Users> parseJSON(String result) {
        ArrayList<Users> users = new ArrayList<Users>();
        try {   
            JSONArray jArray = new JSONArray(result);
            for (int i = 0; i < jArray.length(); i++) {
                JSONObject json_data = jArray.getJSONObject(i);
                Users user = new Users();
                user.setId(json_data.getInt("id"));
                user.setRestaurant(json_data.getString("restaurant"));
                user.setUsername(json_data.getString("username"));
                user.setCountry(json_data.getString("country"));
                user.setCity(json_data.getString("city"));
                user.setWebsite(json_data.getString("website"));
                user.setResumee(json_data.getString("resumee"));
                users.add(user);
            }
        } catch (JSONException e) {
            Log.e("log_tag", "Error parsing data " + e.toString());  
        }
        return users; 
    }
	
		
}