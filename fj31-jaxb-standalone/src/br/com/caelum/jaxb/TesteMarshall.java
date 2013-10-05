package br.com.caelum.jaxb;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class TesteMarshall {
	public static void main(String[] args) throws JAXBException, FileNotFoundException {
		Produto produto = new Produto();
		produto.setNome("bola");
		produto.setPreco(20.34);
		produto.setDescricao("uma bola quadrada");
		
		Categoria categoria = new Categoria();
		categoria.setNome("esporte");
		
		produto.setCategoria(categoria);
		
		JAXBContext context = JAXBContext.newInstance(Produto.class);
		Marshaller marshall = context.createMarshaller();
		marshall.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		//marshall.marshal(produto, new FileOutputStream("bola.xml"));
		marshall.marshal(produto, System.out);
	}
}
