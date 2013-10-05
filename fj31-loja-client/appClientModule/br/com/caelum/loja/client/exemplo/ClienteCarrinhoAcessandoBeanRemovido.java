package br.com.caelum.loja.client.exemplo;

import javax.naming.InitialContext;

import br.com.caelum.loja.entity.Livro;
import br.com.caelum.loja.session.Carrinho;

public class ClienteCarrinhoAcessandoBeanRemovido {

	public static void main(String[] args) throws Exception {
		InitialContext ic = new InitialContext();

		Carrinho c = (Carrinho) ic
				.lookup("ejb:fj31-loja-ear/fj31-loja-ejb3/CarrinhoBean!br.com.caelum.loja.session.Carrinho?stateful");

		Livro livro = new Livro();
		livro.setNome("Fausto");
		livro.setPreco(45.0);
		c.addLivro(livro);
		c.finalizaCompra();
		System.out.println("compra finalizada");

		c.addLivro(livro);
	}

}
