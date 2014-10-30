

import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

public class Soap {
	public Soap()
	{
		
	}

	public void createLoginRequest(String userName, String password)
			throws Exception {
		MessageFactory messageFactory = MessageFactory.newInstance();
		SOAPMessage soapMessage = messageFactory.createMessage();
		SOAPPart soapPart = soapMessage.getSOAPPart();

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

		MimeHeaders headers = soapMessage.getMimeHeaders();
		headers.addHeader("SOAPAction", serverURI + "Login");

		soapMessage.saveChanges();

		System.out.print("Request SOAP Message:");
		soapMessage.writeTo(System.out);
		System.out.println();
		String url = "http://localhost:8080/AndroidServer/services/Login";
		SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory
				.newInstance();
		SOAPConnection soapConnection = soapConnectionFactory
				.createConnection();
		soapConnection.call(soapMessage, url);
	}

	public void createEditAcctRequest(int age, String email, String firstName,
			String lastName, int userID, String phoneNbr) throws Exception {

		MessageFactory messageFactory = MessageFactory.newInstance();
		SOAPMessage soapMessage = messageFactory.createMessage();
		SOAPPart soapPart = soapMessage.getSOAPPart();

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

		MimeHeaders headers = soapMessage.getMimeHeaders();
		headers.addHeader("SOAPAction", serverURI + "UpdateUser");
		headers.addHeader("SOAPAction", "http://jaxb.mckeown.com"
				+ "UpdateUser");

		soapMessage.saveChanges();

		String url = "http://localhost:8080/AndroidServer/services/UpdateUser";
		SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory
				.newInstance();
		SOAPConnection soapConnection = soapConnectionFactory
				.createConnection();
		soapConnection.call(soapMessage, url);

	}

	public void createCreateUserRequest(int age, String email,
			String firstName, String lastName, String userName,
			String password, String phoneNbr) throws Exception {

		MessageFactory messageFactory = MessageFactory.newInstance();
		SOAPMessage soapMessage = messageFactory.createMessage();
		SOAPPart soapPart = soapMessage.getSOAPPart();

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

		MimeHeaders headers = soapMessage.getMimeHeaders();
		headers.addHeader("SOAPAction", serverURI + "UpdateUser");

		soapMessage.saveChanges();

		String url = "http://localhost:8080/AndroidServer/services/CreateUser";
		SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory
				.newInstance();
		SOAPConnection soapConnection = soapConnectionFactory
				.createConnection();
		soapConnection.call(soapMessage, url);

	}

	public void createGetUserDataRequest(int userID) throws Exception {
		MessageFactory messageFactory = MessageFactory.newInstance();
		SOAPMessage soapMessage = messageFactory.createMessage();
		SOAPPart soapPart = soapMessage.getSOAPPart();

		String serverURI = "http://options.mckeown.com";

		// SOAP Envelope
		SOAPEnvelope envelope = soapPart.getEnvelope();
		envelope.addNamespaceDeclaration("opt", serverURI);

		SOAPBody soapBody = envelope.getBody();
		SOAPElement soapBodyElem = soapBody.addChildElement("getData", "opt");
		SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("userID",
				"opt");
		soapBodyElem1.addTextNode(userID + "");

		MimeHeaders headers = soapMessage.getMimeHeaders();
		headers.addHeader("SOAPAction", serverURI + "GetUserData");

		soapMessage.saveChanges();

		String url = "http://localhost:8080/AndroidServer/services/GetUserData";
		SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory
				.newInstance();
		SOAPConnection soapConnection = soapConnectionFactory
				.createConnection();
		soapConnection.call(soapMessage, url);
	}

	public void createDeleteUSerRequest(int userID) throws Exception {
		MessageFactory messageFactory = MessageFactory.newInstance();
		SOAPMessage soapMessage = messageFactory.createMessage();
		SOAPPart soapPart = soapMessage.getSOAPPart();

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

		MimeHeaders headers = soapMessage.getMimeHeaders();
		headers.addHeader("SOAPAction", serverURI + "deleteUser");

		soapMessage.saveChanges();

		String url = "http://localhost:8080/AndroidServer/services/DeleteUser";
		SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory
				.newInstance();
		SOAPConnection soapConnection = soapConnectionFactory
				.createConnection();
		soapConnection.call(soapMessage, url);
	}

}