package br.com.caelum.loja.client.exemplo;

import javax.naming.InitialContext;

import br.com.caelum.loja.entity.Livro;
import br.com.caelum.loja.session.Carrinho;

public class ClienteCarrinhoComMensageiro {
	
	public static void main(String[] args) throws Exception {
		InitialContext ic = new InitialContext();
		Carrinho carrinho = (Carrinho) ic.lookup("ejb:fj31-loja-ear/fj31-loja-ejb3/CarrinhoBean!br.com.caelum.loja.session.Carrinho?stateful"); 
		
		Livro l1 = new Livro();
		l1.setNome("Batman");
		l1.setPreco(50.0);
		
		Livro l2 = new Livro();
		l2.setNome("Spring");
		l2.setPreco(100.0);
		
		carrinho.addLivro(l1);
		carrinho.addLivro(l2);
		
		carrinho.finalizaCompra();
	}
	
}
