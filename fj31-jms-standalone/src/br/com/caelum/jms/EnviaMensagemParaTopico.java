package br.com.caelum.jms;

import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

public class EnviaMensagemParaTopico {
	public static void main(String[] args) throws Exception {
		Properties jndiProperties = new Properties();
		jndiProperties.put(Context.SECURITY_PRINCIPAL, "jms");
		jndiProperties.put(Context.SECURITY_CREDENTIALS, "caelum");
		
		InitialContext ic = new InitialContext(jndiProperties);
		
		ConnectionFactory cf = (ConnectionFactory) ic.lookup("jms/RemoteConnectionFactory");
		Connection con = cf.createConnection("jms", "caelum");
		Session session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		TextMessage textMessage = session.createTextMessage();
		textMessage.setText("Mensagem de texto para um Topic");
		
		Destination queue = (Destination) ic.lookup("jms/topic/loja");
		MessageProducer sender = session.createProducer(queue);
		sender.send(textMessage);
		
		con.close();
	}
}
