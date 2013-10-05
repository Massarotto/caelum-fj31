package br.com.caelum.loja.client.exemplo;

import javax.naming.InitialContext;

import br.com.caelum.loja.entity.Livro;
import br.com.caelum.loja.session.GerenciadorLoja;

public class ClienteGerenciador {
	
	public static void main(String[] args) throws Exception {
		InitialContext ic = new InitialContext();
		GerenciadorLoja gerenciado = (GerenciadorLoja) ic.lookup("ejb:fj31-loja-ear/fj31-loja-ejb3/GerenciadorLojaBean!br.com.caelum.loja.session.GerenciadorLoja");
		
		Livro l = new Livro();
		l.setNome("Capitao America");
		l.setPreco(31);
		
		gerenciado.salva(l);
	}
	
}
