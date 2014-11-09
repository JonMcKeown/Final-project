package com.mckeown.practicum;

import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

import com.sun.xml.messaging.saaj.soap.impl.TextImpl;








public class Soap {
	String url;
	public Soap(String url)
	{
		this.url= url;
	}

	public int createLoginRequest(String userName, String password)
			throws Exception {
		MessageFactory messageFactory = MessageFactory.newInstance();
		SOAPMessage SOAPMessage = messageFactory.createMessage();
		SOAPPart soapPart = SOAPMessage.getSOAPPart();

		String serverURI = "http://options.mckeown.com";

		// SOAP Envelope
		SOAPEnvelope envelope = soapPart.getEnvelope();
		envelope.addNamespaceDeclaration("opt", serverURI);

		// SOAP Body
		SOAPBody soapBody = envelope.getBody();
		SOAPElement soapBodyElem = soapBody.addChildElement("Login", "opt");
		SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("userName",
				"opt");
		soapBodyElem1.addTextNode(userName);
		SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("password",
				"opt");
		soapBodyElem2.addTextNode(password);

		MimeHeaders headers = SOAPMessage.getMimeHeaders();
		headers.addHeader("SOAPAction", serverURI + "Login");

		SOAPMessage.saveChanges();

		String url = this.url+"Login";
		SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory
				.newInstance();
		SOAPConnection soapConnection = soapConnectionFactory
				.createConnection();
		SOAPMessage response = soapConnection.call(SOAPMessage, url);
		//response.writeTo(System.out);
		SOAPBody body= response.getSOAPBody();  
        SOAPElement element = (SOAPElement) body.getChildElements().next(); 
        SOAPElement element2 = (SOAPElement) element.getChildElements().next(); 
        TextImpl e = (TextImpl) element2.getChildElements().next(); 
        return Integer.parseInt(e.getData());

		

		
	}

	public boolean createEditAcctRequest(int age, String email, String firstName,
			String lastName, int userID, String phoneNbr) throws Exception {

		MessageFactory messageFactory = MessageFactory.newInstance();
		SOAPMessage SOAPMessage = messageFactory.createMessage();
		SOAPPart soapPart = SOAPMessage.getSOAPPart();

		String serverURI = "http://options.mckeown.com";

		// SOAP Envelope
		SOAPEnvelope envelope = soapPart.getEnvelope();
		envelope.addNamespaceDeclaration("opt", "http://options.mckeown.com");
		envelope.addNamespaceDeclaration("jaxb", "http://jaxb.mckeown.com");

		// SOAP Body
		SOAPBody soapBody = envelope.getBody();
		SOAPElement soapBodyElem8 = soapBody.addChildElement("update", "opt");
		SOAPElement soapBodyElem = soapBodyElem8.addChildElement("acct", "opt");
		SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("age", "jaxb");
		soapBodyElem2.addTextNode(age + "");
		SOAPElement soapBodyElem3 = soapBodyElem.addChildElement("email",
				"jaxb");
		soapBodyElem3.addTextNode(email);
		SOAPElement soapBodyElem4 = soapBodyElem.addChildElement("firstName",
				"jaxb");
		soapBodyElem4.addTextNode(firstName);
		SOAPElement soapBodyElem5 = soapBodyElem.addChildElement("lastName",
				"jaxb");
		soapBodyElem5.addTextNode(lastName);
		SOAPElement soapBodyElem6 = soapBodyElem.addChildElement("phoneNbr",
				"jaxb");
		soapBodyElem6.addTextNode(phoneNbr);
		SOAPElement soapBodyElem7 = soapBodyElem.addChildElement("userID",
				"jaxb");
		soapBodyElem7.addTextNode(userID + "");

		MimeHeaders headers = SOAPMessage.getMimeHeaders();
		headers.addHeader("SOAPAction", serverURI + "UpdateUser");
		headers.addHeader("SOAPAction", "http://jaxb.mckeown.com"
				+ "UpdateUser");

		SOAPMessage.saveChanges();

		String url = this.url+"UpdateUser";
		SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory
				.newInstance();
		SOAPConnection soapConnection = soapConnectionFactory
				.createConnection();
		SOAPMessage response = soapConnection.call(SOAPMessage, url);
		
		SOAPBody body= response.getSOAPBody();  
        SOAPElement element = (SOAPElement) body.getChildElements().next(); 
        SOAPElement element2 = (SOAPElement) element.getChildElements().next(); 
        TextImpl e = (TextImpl) element2.getChildElements().next(); 
        return e.getData().toLowerCase().equals("true");
	}

	public int createCreateUserRequest(int age, String email,
			String firstName, String lastName, String userName,
			String password, String phoneNbr) throws Exception {

		MessageFactory messageFactory = MessageFactory.newInstance();
		SOAPMessage SOAPMessage = messageFactory.createMessage();
		SOAPPart soapPart = SOAPMessage.getSOAPPart();

		String serverURI = "http://options.mckeown.com";

		// SOAP Envelope
		SOAPEnvelope envelope = soapPart.getEnvelope();
		envelope.addNamespaceDeclaration("opt", "http://options.mckeown.com");

		// SOAP Body
		SOAPBody soapBody = envelope.getBody();
		SOAPElement soapBodyElem = soapBody
				.addChildElement("createUser", "opt");
		SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("userName",
				"opt");
		soapBodyElem2.addTextNode(userName);
		SOAPElement soapBodyElem3 = soapBodyElem.addChildElement("password",
				"opt");
		soapBodyElem3.addTextNode(password);
		SOAPElement soapBodyElem4 = soapBodyElem.addChildElement("age", "opt");
		soapBodyElem4.addTextNode(age + "");
		SOAPElement soapBodyElem5 = soapBodyElem
				.addChildElement("email", "opt");
		soapBodyElem5.addTextNode(email);
		SOAPElement soapBodyElem6 = soapBodyElem.addChildElement("phoneNbr",
				"opt");
		soapBodyElem6.addTextNode(phoneNbr);
		SOAPElement soapBodyElem7 = soapBodyElem.addChildElement("firstName",
				"opt");
		soapBodyElem7.addTextNode(firstName);
		SOAPElement soapBodyElem8 = soapBodyElem.addChildElement("lastName",
				"opt");
		soapBodyElem8.addTextNode(lastName);

		MimeHeaders headers = SOAPMessage.getMimeHeaders();
		headers.addHeader("SOAPAction", serverURI + "UpdateUser");

		SOAPMessage.saveChanges();

		String url = this.url+"CreateUser";
		SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory
				.newInstance();
		SOAPConnection soapConnection = soapConnectionFactory
				.createConnection();
		SOAPMessage response = soapConnection.call(SOAPMessage, url);
		
		SOAPBody body= response.getSOAPBody();  
        SOAPElement element = (SOAPElement) body.getChildElements().next(); 
        SOAPElement element2 = (SOAPElement) element.getChildElements().next(); 
        TextImpl e = (TextImpl) element2.getChildElements().next(); 
        return Integer.parseInt(e.getData());

	}

	public User createGetUserDataRequest(int userID) throws Exception {
		MessageFactory messageFactory = MessageFactory.newInstance();
		SOAPMessage SOAPMessage = messageFactory.createMessage();
		SOAPPart soapPart = SOAPMessage.getSOAPPart();

		String serverURI = "http://options.mckeown.com";

		// SOAP Envelope
		SOAPEnvelope envelope = soapPart.getEnvelope();
		envelope.addNamespaceDeclaration("opt", serverURI);

		SOAPBody soapBody = envelope.getBody();
		SOAPElement soapBodyElem = soapBody.addChildElement("getData", "opt");
		SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("userID",
				"opt");
		soapBodyElem1.addTextNode(userID + "");

		MimeHeaders headers = SOAPMessage.getMimeHeaders();
		headers.addHeader("SOAPAction", serverURI + "GetUserData");

		SOAPMessage.saveChanges();

		String url = this.url+"GetUserData";
		SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory
				.newInstance();
		SOAPConnection soapConnection = soapConnectionFactory
				.createConnection();
		SOAPMessage response = soapConnection.call(SOAPMessage, url);
		
		SOAPBody body= response.getSOAPBody();  
        SOAPElement element = (SOAPElement) body.getChildElements().next(); 
        SOAPElement element2 = (SOAPElement) element.getChildElements().next(); 
        SOAPElement element3 = (SOAPElement) element.getChildElements().next();
        ArrayList<String> a = new ArrayList<String>();
        Iterator i = element3.getChildElements();
        User user;
    	String age = ((TextImpl) ((SOAPElement)i.next()).getChildElements().next()).getData();
    	String email = ((TextImpl) ((SOAPElement)i.next()).getChildElements().next()).getData();
    	String first = ((TextImpl) ((SOAPElement)i.next()).getChildElements().next()).getData();
    	String last = ((TextImpl) ((SOAPElement)i.next()).getChildElements().next()).getData();
    	String phone = ((TextImpl) ((SOAPElement)i.next()).getChildElements().next()).getData();
    	String userid =((TextImpl) ((SOAPElement)i.next()).getChildElements().next()).getData();
    	user = new User(userID, Integer.parseInt(age), email, phone, first, last);
    	//a.add(i.next().toString());
        //TextImpl e = (TextImpl) element2.getChildElements().next(); 
        return user;

	}

	public boolean createDeleteUserRequest(int userID) throws Exception {
		MessageFactory messageFactory = MessageFactory.newInstance();
		SOAPMessage SOAPMessage = messageFactory.createMessage();
		SOAPPart soapPart = SOAPMessage.getSOAPPart();

		String serverURI = "http://options.mckeown.com";

		// SOAP Envelope
		SOAPEnvelope envelope = soapPart.getEnvelope();
		envelope.addNamespaceDeclaration("opt", serverURI);

		SOAPBody soapBody = envelope.getBody();
		SOAPElement soapBodyElem = soapBody
				.addChildElement("deleteUser", "opt");
		SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("userID",
				"opt");
		soapBodyElem1.addTextNode(userID + "");

		MimeHeaders headers = SOAPMessage.getMimeHeaders();
		headers.addHeader("SOAPAction", serverURI + "deleteUser");

		SOAPMessage.saveChanges();

		String url = this.url+"DeleteUser";
		SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory
				.newInstance();
		SOAPConnection soapConnection = soapConnectionFactory
				.createConnection();
		SOAPMessage response = soapConnection.call(SOAPMessage, url);
		
		SOAPBody body= response.getSOAPBody();  
        SOAPElement element = (SOAPElement) body.getChildElements().next(); 
        SOAPElement element2 = (SOAPElement) element.getChildElements().next(); 
        TextImpl e = (TextImpl) element2.getChildElements().next(); 
        return e.getData().toLowerCase().equals("true");
	}

}