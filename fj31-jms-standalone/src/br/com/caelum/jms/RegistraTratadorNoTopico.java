package br.com.caelum.jms;

import java.util.Properties;
import java.util.Scanner;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;

public class RegistraTratadorNoTopico {
	public static void main(String[] args) throws Exception {
		Properties jndiProperties = new Properties();
		jndiProperties.put(Context.SECURITY_PRINCIPAL, "jms");
		jndiProperties.put(Context.SECURITY_CREDENTIALS, "caelum");
		
		InitialContext ic = new InitialContext(jndiProperties);
		
		ConnectionFactory cf = (ConnectionFactory) ic.lookup("jms/RemoteConnectionFactory");
		Connection con = cf.createConnection("jms", "caelum");
		Session session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		Destination topic = (Destination) ic.lookup("jms/topic/loja");
		
		MessageConsumer consumer = session.createConsumer(topic);
		consumer.setMessageListener(new TratadorDeMensagem());
		con.start();
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Esperando as mensagens no topic JMS. Aperte ENTER para parar");
		teclado.nextLine();
		
		con.close();
	}
}
