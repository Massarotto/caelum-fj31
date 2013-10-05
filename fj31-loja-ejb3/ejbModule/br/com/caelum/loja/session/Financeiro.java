package br.com.caelum.loja.session;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJBException;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig={@ActivationConfigProperty(propertyName="destination", propertyValue="queue/loja")})
public class Financeiro implements MessageListener{

	@Override
	public void onMessage(Message msg) {
		String text;
		try {
			text = ((TextMessage) msg).getText();
			System.out.println("Financeiro processando informação " + text);
		} catch (JMSException e) {
			throw new EJBException();
		}
		
	}

}
