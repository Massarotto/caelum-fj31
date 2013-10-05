package br.com.caelum.loja.client.exemplo;

import javax.naming.InitialContext;

import br.com.caelum.loja.entity.Livro;
import br.com.caelum.loja.session.Carrinho;

public class ClienteCarrinhoTestaPassivacao {

	public static void main(String[] args) throws Exception {
		InitialContext ic = new InitialContext();
		
		Carrinho primeiroCarrinho = (Carrinho) ic.lookup("ejb:fj31-loja-ear/fj31-loja-ejb3/CarrinhoBean!br.com.caelum.loja.session.Carrinho?stateful");
		
		Livro livro = new Livro();
		livro.setNome("Fausto");
		livro.setPreco(45.0);
		
		primeiroCarrinho.addLivro(livro);
		
		Thread.sleep(50000);
		
		for(int i = 0; i < 50; i++) {
			Carrinho carrinho = (Carrinho) ic.lookup("ejb:fj31-loja-ear/fj31-loja-ejb3/CarrinhoBean!br.com.caelum.loja.session.Carrinho?stateful");
			carrinho.addLivro(livro);
		}
		
		primeiroCarrinho.addLivro(livro);
	}
	
}
