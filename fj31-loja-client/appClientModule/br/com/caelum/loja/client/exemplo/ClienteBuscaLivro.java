package br.com.caelum.loja.client.exemplo;

import java.util.List;

import javax.naming.InitialContext;

import br.com.caelum.loja.entity.Autor;
import br.com.caelum.loja.entity.Livro;
import br.com.caelum.loja.session.GerenciadorLoja;

public class ClienteBuscaLivro {
	public static void main(String[] args) throws Exception {
		InitialContext ic = new InitialContext();
		GerenciadorLoja gerenciado = (GerenciadorLoja) ic.lookup("ejb:fj31-loja-ear/fj31-loja-ejb3/GerenciadorLojaBean!br.com.caelum.loja.session.GerenciadorLoja");
		
		Livro livro = gerenciado.procura(7L);
		
		List<Autor> autores = livro.getAutores();
		for(Autor a : autores) {
			System.out.println(a.getNome());
		}
		 
	}
}
