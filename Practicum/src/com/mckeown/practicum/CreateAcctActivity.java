package com.mckeown.practicum;

import java.util.concurrent.ExecutionException;

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

public class CreateAcctActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_acct);
		
		final Button CreateButton = (Button) findViewById(R.id.createUserButton);
        CreateButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	EditText userName = (EditText) findViewById(R.id.createUserName);
            	EditText password = (EditText) findViewById(R.id.createPassword);
            	EditText age = (EditText) findViewById(R.id.createAge);
            	EditText email = (EditText) findViewById(R.id.createEmail);
            	EditText phoneNbr = (EditText) findViewById(R.id.createPhoneNbr);
            	EditText firstName = (EditText) findViewById(R.id.createFirst);
            	EditText lastName = (EditText) findViewById(R.id.createLast);
            	String[] params = new String[]{userName.getText().toString(),password.getText().toString(),age.getText().toString(),email.getText().toString(),phoneNbr.getText().toString(),firstName.getText().toString(),lastName.getText().toString()};
            	CreateUser newUser = new CreateUser();
            	String good = "";
            	try {
					good = newUser.execute(params).get();
				} catch (Exception e) {
					e.printStackTrace();
				}
            	if(!good.equals("0"))
            	{
            		finish();
            		Toast.makeText(getApplicationContext(), good, Toast.LENGTH_SHORT).show();

            	}
            	else if(good.equals(""))
            		Toast.makeText(getApplicationContext(), "Create User Failed", Toast.LENGTH_SHORT).show();
            	else
            		Toast.makeText(getApplicationContext(), "User Name already taken", Toast.LENGTH_SHORT).show();

            }
            	
        });
		

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.create_acct, menu);
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
	
	private class CreateUser extends AsyncTask<String, Void, String> {
        protected String doInBackground(String... params) {
        	String url = "http://practicum-mckeown.rhcloud.com/AndroidServer/services/CreateUser";
    	    SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
    	    soapEnvelope.implicitTypes = true;
    	    soapEnvelope.dotNet = true;
    	    SoapObject soapReq = new SoapObject("http://options.mckeown.com","createUser");
    	    soapReq.addProperty("userName",params[0]);
    	    soapReq.addProperty("password",params[1]);
    	    soapReq.addProperty("age",params[2]);
    	    soapReq.addProperty("email",params[3]);
    	    soapReq.addProperty("phoneNbr",params[4]);
    	    soapReq.addProperty("firstName",params[5]);
    	    soapReq.addProperty("lastName",params[6]);
    	    soapEnvelope.setOutputSoapObject(soapReq);
    	    HttpTransportSE httpTransport = new HttpTransportSE(url,60000);
    	    try{

	            httpTransport.call("http://options.mckeown.com/createUser", soapEnvelope);
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



