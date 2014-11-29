

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.ksoap2.HeaderProperty;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.*;
import org.ksoap2.transport.HttpTransportSE;


public class SoapClient {
	 private static String NAMESPACE = "http://options.mckeown.com";
     private static String URL = "http://practicum-mckeown.rhcloud.com/AndroidServer/services/Login?wsdl";
     private static String SOAP_ACTION = "http://options.mckeown.com/Login";
     private static String METHOD_NAME = "Login";

     

	public static void main (String[]args)
	{
		
		System.out.print(login("Jonm385","password"));

	}
	
	public static String login(String userName,String password){
        return login(userName, password, null);
    }
    
    public static String login(String userName,String password,List<HeaderProperty> headers){
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
            if (headers!=null){
                httpTransport.call("http://options.mckeown.com/login", soapEnvelope,headers);
            }else{
                httpTransport.call("http://options.mckeown.com/login", soapEnvelope);
            }
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

}