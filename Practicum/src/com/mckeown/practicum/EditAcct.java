package com.mckeown.practicum;


//------------------------------------------------------------------------------
// <wsdl2code-generated>
//    This code was generated by http://www.wsdl2code.com version  2.5
//
// Date Of Creation: 11/29/2014 8:18:46 AM
//    Please dont change this code, regeneration will override your changes
//</wsdl2code-generated>
//
//------------------------------------------------------------------------------
//
//This source code was auto-generated by Wsdl2Code  Version
//
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import java.util.Hashtable;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

public class EditAcct implements KvmSerializable {
    
    public int age;
    public String email;
    public String firstName;
    public String lastName;
    public boolean newAcct;
    public String password;
    public String phoneNbr;
    public int userID;
    public String userName;
    
    public EditAcct(){}
    
    public EditAcct(SoapObject soapObject)
    {
        if (soapObject == null)
            return;
        if (soapObject.hasProperty("age"))
        {
            Object obj = soapObject.getProperty("age");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                age = Integer.parseInt(j.toString());
            }else if (obj!= null && obj instanceof Number){
                age = (Integer) obj;
            }
        }
        if (soapObject.hasProperty("email"))
        {
            Object obj = soapObject.getProperty("email");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                email = j.toString();
            }else if (obj!= null && obj instanceof String){
                email = (String) obj;
            }
        }
        if (soapObject.hasProperty("firstName"))
        {
            Object obj = soapObject.getProperty("firstName");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                firstName = j.toString();
            }else if (obj!= null && obj instanceof String){
                firstName = (String) obj;
            }
        }
        if (soapObject.hasProperty("lastName"))
        {
            Object obj = soapObject.getProperty("lastName");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                lastName = j.toString();
            }else if (obj!= null && obj instanceof String){
                lastName = (String) obj;
            }
        }
        if (soapObject.hasProperty("newAcct"))
        {
            Object obj = soapObject.getProperty("newAcct");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                newAcct = Boolean.parseBoolean(j.toString());
            }else if (obj!= null && obj instanceof Boolean){
                newAcct = (Boolean) obj;
            }
        }
        if (soapObject.hasProperty("password"))
        {
            Object obj = soapObject.getProperty("password");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                password = j.toString();
            }else if (obj!= null && obj instanceof String){
                password = (String) obj;
            }
        }
        if (soapObject.hasProperty("phoneNbr"))
        {
            Object obj = soapObject.getProperty("phoneNbr");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                phoneNbr = j.toString();
            }else if (obj!= null && obj instanceof String){
                phoneNbr = (String) obj;
            }
        }
        if (soapObject.hasProperty("userID"))
        {
            Object obj = soapObject.getProperty("userID");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                userID = Integer.parseInt(j.toString());
            }else if (obj!= null && obj instanceof Number){
                userID = (Integer) obj;
            }
        }
        if (soapObject.hasProperty("userName"))
        {
            Object obj = soapObject.getProperty("userName");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)){
                SoapPrimitive j =(SoapPrimitive) obj;
                userName = j.toString();
            }else if (obj!= null && obj instanceof String){
                userName = (String) obj;
            }
        }
    }
    @Override
    public Object getProperty(int arg0) {
        switch(arg0){
            case 0:
                return age;
            case 1:
                return email;
            case 2:
                return firstName;
            case 3:
                return lastName;
            case 4:
                return newAcct;
            case 5:
                return password;
            case 6:
                return phoneNbr;
            case 7:
                return userID;
            case 8:
                return userName;
        }
        return null;
    }
    
    @Override
    public int getPropertyCount() {
        return 9;
    }
    
    @Override
    public void getPropertyInfo(int index, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
        switch(index){
            case 0:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "age";
                break;
            case 1:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "email";
                break;
            case 2:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "firstName";
                break;
            case 3:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "lastName";
                break;
            case 4:
                info.type = PropertyInfo.BOOLEAN_CLASS;
                info.name = "newAcct";
                break;
            case 5:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "password";
                break;
            case 6:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "phoneNbr";
                break;
            case 7:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "userID";
                break;
            case 8:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "userName";
                break;
        }
    }
    
    @Override
    public void setProperty(int arg0, Object arg1) {
    }
    
}
