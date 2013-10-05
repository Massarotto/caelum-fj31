package br.com.caelum.loja.client.exemplo;

import javax.naming.InitialContext;

import br.com.caelum.loja.entity.Livro;
import br.com.caelum.loja.session.GerenciadorLoja;

public class ClienteProcuraLivro {
	
	public static void main(String[] args) throws Exception {
		InitialContext ic = new InitialContext();
		GerenciadorLoja gerenciador = (GerenciadorLoja) ic.lookup("ejb:fj31-loja-ear/fj31-loja-ejb3/GerenciadorLojaBean!br.com.caelum.loja.session.GerenciadorLoja");
		Livro livro = gerenciador.procura("1111");
		System.out.println(livro.getNome());
	}
	
}
