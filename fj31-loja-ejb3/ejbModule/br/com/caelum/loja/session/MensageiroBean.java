package br.com.caelum.loja.session;

import java.io.StringWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJBAccessException;
import javax.ejb.EJBException;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.jboss.resteasy.plugins.providers.jaxb.JaxbCollection;

import br.com.caelum.loja.entity.Livro;
import br.com.caelum.loja.util.Livros;

@Stateless
@Local(Mensageiro.class)
public class MensageiroBean implements Mensageiro{
	
	@Resource(mappedName="java:/ConnectionFactory")
	private ConnectionFactory factory;
	
	@Resource(mappedName="java:/queue/loja")
	private Destination destination;
	
	@Override
	public void enviaMensagem(List<Livro> livros) {
		try {
			//criando uma sessao
			Connection conexao = this.factory.createConnection("jms", "caelum");
			Session session = conexao.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			//criando o wrapper jaxb
			Livros wrapper = new Livros();
			wrapper.adicionaLivros(livros);
			
			//gerando XML
			Marshaller marshaller = JAXBContext.newInstance(Livros.class).createMarshaller();
			StringWriter stringWriter = new StringWriter();
			marshaller.marshal(wrapper, stringWriter);
			
			//criando mensagem jms
			TextMessage textMessage = session.createTextMessage(stringWriter.toString());
			
			//criando produtor de mensagem
			MessageProducer produtor = session.createProducer(this.destination);
			produtor.send(textMessage);
			
			//fechando conexao
			produtor.close();
			conexao.close();
		}catch (JMSException e) {
			throw new EJBException(e);
		} catch (JAXBException e) {
			throw new EJBException(e);
		}
		
		
	}

}
