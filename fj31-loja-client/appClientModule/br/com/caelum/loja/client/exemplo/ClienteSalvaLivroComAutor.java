package br.com.caelum.loja.client.exemplo;

import javax.naming.InitialContext;

import br.com.caelum.loja.entity.Autor;
import br.com.caelum.loja.entity.Livro;
import br.com.caelum.loja.session.GerenciadorLoja;

public class ClienteSalvaLivroComAutor {

	public static void main(String[] args) throws Exception {
		InitialContext ic = new InitialContext();
		GerenciadorLoja gerenciador = (GerenciadorLoja) ic
				.lookup("ejb:fj31-loja-ear/fj31-loja-ejb3/GerenciadorLojaBean!br.com.caelum.loja.session.GerenciadorLoja");

		Autor autor = new Autor();
		autor.setNome("Paulo Coelho");
		Livro livro = new Livro();
		livro.setNome("Conto de fadas");
		livro.setPreco(50);

		autor = gerenciador.salva(autor);
		System.out.println("Id do autor: " + autor.getId());
		
		livro.getAutores().add(autor);
		gerenciador.salva(livro);
	}

}
