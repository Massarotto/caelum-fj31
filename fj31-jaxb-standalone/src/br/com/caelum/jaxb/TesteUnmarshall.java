package br.com.caelum.jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class TesteUnmarshall {
	public static void main(String[] args) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(Produto.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		Produto produto = (Produto) unmarshaller.unmarshal(new File("bola.xml"));
		System.out.println(produto.getNome());
		System.out.println("Categoria: " + produto.getCategoria().getNome());
	}
}
