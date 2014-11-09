package com.mckeown.practicum;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final Button button = (Button) findViewById(R.id.loginButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	EditText userName = (EditText) findViewById(R.id.userNameField); 
            	EditText pass = (EditText) findViewById(R.id.passwordField); 
                if(!userName.toString().equals("") && !pass.toString().equals(""))
                {
                	String url = "http://practicum-mckeown.rhcloud.com/AndroidServer/services/";
                	Soap soapRequester = new Soap(url);
                	try{
                		
                		int id = soapRequester.createLoginRequest(userName.toString().trim(), pass.toString().trim());
                		Toast.makeText(getApplicationContext(),id,Toast.LENGTH_SHORT).show();
                	}catch(Exception e)
                	{
                		e.printStackTrace();
                	}
                }
            }
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
}
