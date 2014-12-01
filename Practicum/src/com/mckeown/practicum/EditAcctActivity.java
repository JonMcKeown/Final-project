package com.mckeown.practicum;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditAcctActivity extends Activity {
	EditAcct user = new EditAcct();
	String userid = "";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_acct);
		Intent intent = getIntent();
		this.userid = intent.getStringExtra("id");

		GetUserData getUser = new GetUserData();
		try {
			getUser.execute(userid).get();
		} catch (Exception e) {
			e.printStackTrace();
		}		

		String age = user.getProperty(0).toString();
		String email = user.getProperty(1).toString();
		String phoneNbr = user.getProperty(6).toString();
		String firstName = user.getProperty(3).toString();
		String lastName = user.getProperty(2).toString();
		
    	EditText ageField = (EditText) findViewById(R.id.editAge);
    	EditText emailField = (EditText) findViewById(R.id.editEmail);
    	EditText phoneNbrField = (EditText) findViewById(R.id.editPhoneNbr);
    	EditText firstNameField = (EditText) findViewById(R.id.editFirst);
    	EditText lastNameField = (EditText) findViewById(R.id.editLast);
    	
    	ageField.setText(age);
    	emailField.setText(email);
    	phoneNbrField.setText(phoneNbr);
    	firstNameField.setText(firstName);
    	lastNameField.setText(lastName);
    	
    	final AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("Are you sure you want to delete this user?");
        builder1.setCancelable(true);
        builder1.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            	DeleteUser delete = new DeleteUser();
            	String[] params = new String[]{userid};
            	try {
					delete.execute(params).get();
				} catch (Exception e) {
					e.printStackTrace();
				}
            	finish();
                dialog.cancel();
            }
        });
        builder1.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });

      
    	
    	final Button deleteButton = (Button) findViewById(R.id.deleteUserButton);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	  AlertDialog alert11 = builder1.create();
                  alert11.show();
            }
            	
        });
        
        final Button updateButton = (Button) findViewById(R.id.updateUserButton);
        updateButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	  
            	EditText age = (EditText) findViewById(R.id.editAge);
            	EditText email = (EditText) findViewById(R.id.editEmail);
            	EditText phoneNbr = (EditText) findViewById(R.id.editPhoneNbr);
            	EditText firstName = (EditText) findViewById(R.id.editFirst);
            	EditText lastName = (EditText) findViewById(R.id.editLast);
            
            	String[] params = new String[]{age.getText().toString(),email.getText().toString(),firstName.getText().toString(),lastName.getText().toString(),phoneNbr.getText().toString(),userid};
            	
            	updateUser user = new updateUser();
            	try {
					user.execute(params).get();
				} catch (Exception e) {
					e.printStackTrace();
				}
        		Toast.makeText(getApplicationContext(), "Account updated", Toast.LENGTH_SHORT).show();
            }
            	
        });
    	
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit_acct, menu);
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
	
	private class GetUserData extends AsyncTask<String, Void, String> {
        protected String doInBackground(String... params) {
        	String url = "http://practicum-mckeown.rhcloud.com/AndroidServer/services/GetUserData";
        	SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            soapEnvelope.implicitTypes = true;
            soapEnvelope.dotNet = true;
            SoapObject soapReq = new SoapObject("http://options.mckeown.com","getData");
            soapReq.addProperty("userID",params[0]);
            soapEnvelope.setOutputSoapObject(soapReq);
            HttpTransportSE httpTransport = new HttpTransportSE(url,60000);
            try{

                httpTransport.call("http://options.mckeown.com/getData", soapEnvelope);
                Object retObj = soapEnvelope.bodyIn;
                if (retObj instanceof SoapFault){
                    SoapFault fault = (SoapFault)retObj;
                    Exception ex = new Exception(fault.faultstring);
                }else{
                    SoapObject result=(SoapObject)retObj;
                    if (result.getPropertyCount() > 0){
                        Object obj = result.getProperty(0);
                        SoapObject j = (SoapObject)obj;
                        EditAcct resultVariable =  new EditAcct (j);
                        user = resultVariable;
                        return "";
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
	
	private class DeleteUser extends AsyncTask<String, Void, String> {
        protected String doInBackground(String... params) {
        	String url = "http://practicum-mckeown.rhcloud.com/AndroidServer/services/DeleteUser";
        	SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            soapEnvelope.implicitTypes = true;
            soapEnvelope.dotNet = true;
            SoapObject soapReq = new SoapObject("http://options.mckeown.com","deleteUser");
            soapReq.addProperty("userID",Integer.parseInt(params[0]));
            soapEnvelope.setOutputSoapObject(soapReq);
            HttpTransportSE httpTransport = new HttpTransportSE(url,60000);
            try{

                httpTransport.call("http://options.mckeown.com/deleteUser", soapEnvelope);
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
                            return j.toString();
                        }else if (obj!= null && obj instanceof Boolean){
                            boolean resultVariable = (Boolean) obj;
                            return (String) obj;
                        }
                    }
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
            return "false";
        }
        
        @Override
        protected void onPostExecute(String result) {
        }
        

        @Override
        protected void onPreExecute() {}

        @Override
        protected void onProgressUpdate(Void... values) {}
    }
	
	private class updateUser extends AsyncTask<String, Void, String> {
        protected String doInBackground(String... params) {
        	String url = "http://practicum-mckeown.rhcloud.com/AndroidServer/services/UpdateUser";
        	SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            soapEnvelope.implicitTypes = true;
            soapEnvelope.dotNet = true;
            SoapObject soapReq = new SoapObject("http://options.mckeown.com","update");
            soapEnvelope.addMapping("http://options.mckeown.com","acct",new EditAcctUpdate().getClass());
            
            SoapObject soap = new SoapObject();
            soap.addProperty("age", Integer.parseInt(params[0]));
            soap.addProperty("email", params[1]);
            soap.addProperty("firstName", params[2]);
            soap.addProperty("lastName", params[3]);
            soap.addProperty("phoneNbr", params[4]);
            soap.addProperty("userID", Integer.parseInt(params[5]));
            EditAcctUpdate update = new EditAcctUpdate(soap);
            Logger logger = Logger.getLogger("foo");
            logger.log(Level.INFO, update.getProperty(0).toString()+params[0]);
            logger.log(Level.INFO, update.getProperty(1).toString());
            logger.log(Level.INFO, update.getProperty(2).toString());
            logger.log(Level.INFO, update.getProperty(3).toString());
            logger.log(Level.INFO, update.getProperty(4).toString());
            logger.log(Level.INFO, update.getProperty(5).toString()+params[5]);


            soapReq.addProperty("acct",update);
            soapEnvelope.setOutputSoapObject(soapReq);
            logger.log(Level.INFO,soapReq.toString());
            HttpTransportSE httpTransport = new HttpTransportSE(url,60000);
            try{
                httpTransport.call("http://options.mckeown.com/update", soapEnvelope);
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
                            boolean resultVariable = Boolean.parseBoolean(j.toString());
                            return j.toString();
                        }else if (obj!= null && obj instanceof Boolean){
                            boolean resultVariable = (Boolean) obj;
                            return "false";
                        }
                    }
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
            return "false";
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
