package com.mckeown.practicum;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import java.util.Hashtable;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

public class EditAcctUpdate implements KvmSerializable {
    
    public int age;
    public String email;
    public String firstName;
    public String lastName;
    public String phoneNbr;
    public int userID;
    
    public EditAcctUpdate(){}
    
    public EditAcctUpdate(SoapObject soapObject)
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
                return phoneNbr;
            case 5:
                return userID;
        }
        return null;
    }
    
    @Override
    public int getPropertyCount() {
        return 6;
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
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "phoneNbr";
                break;
            case 5:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "userID";
                break;
        }
    }
    
    @Override
    public void setProperty(int arg0, Object arg1) {
    }
    
}
