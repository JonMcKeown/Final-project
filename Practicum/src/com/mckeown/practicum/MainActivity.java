package com.mckeown.practicum;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	private String id = "";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		
		final Button loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	EditText userName = (EditText) findViewById(R.id.userNameField); 
            	EditText pass = (EditText) findViewById(R.id.passwordField); 
                if(!userName.toString().equals("") && !pass.toString().equals(""))
                {
                	     	
                	try{
                		LoginRequest login = new LoginRequest();
                		String r = login.execute(userName.getText().toString(),pass.getText().toString()).get();
                    	Toast.makeText(getApplicationContext(),r,Toast.LENGTH_SHORT).show();
                		
                	}catch(Exception e)
                	{
                		e.printStackTrace();
                	}
                }
            }
        });
        final Button CreateButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	Intent i = new Intent(this, CreateAcctActivity.class)
                //intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(i);
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

	private class LoginRequest extends AsyncTask<String, Void, String> {
        protected String doInBackground(String... params) {
        	String userName = params[0];
        	String password = params[1];
        	String url = "http://practicum-mckeown.rhcloud.com/AndroidServer/services/Login";
            SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            soapEnvelope.implicitTypes = true;
            soapEnvelope.dotNet = true;
            SoapObject soapReq = new SoapObject("http://options.mckeown.com","login");
            soapReq.addProperty("userName",userName);
            soapReq.addProperty("password",password);
            soapEnvelope.setOutputSoapObject(soapReq);
            HttpTransportSE httpTransport = new HttpTransportSE(url,60000);
            try{

                httpTransport.call("http://options.mckeown.com/login", soapEnvelope);
                Object retObj = soapEnvelope.bodyIn;
                if (retObj instanceof SoapFault){
                    SoapFault fault = (SoapFault)retObj;
                    Exception ex = new Exception(fault.faultstring);
                }else{
                    SoapObject result=(SoapObject)retObj;
                    if (result.getPropertyCount() > 0){
                        Object obj = result.getProperty(0);
                        if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                            SoapPrimitive j =(SoapPrimitive) obj;
                            String resultVariable = j.toString();
                            return resultVariable;
                        }else if (obj!= null && obj instanceof String){
                            String resultVariable = (String) obj;
                            return resultVariable;
                        }
                    }
                }
            }catch (Exception e) {
               
                e.printStackTrace();
            }
            return "";
        }
        
        @Override
        protected void onPostExecute(String result) {
        }
        

        @Override
        protected void onPreExecute() {}

        @Override
        protected void onProgressUpdate(Void... values) {}
    }
	 
}
