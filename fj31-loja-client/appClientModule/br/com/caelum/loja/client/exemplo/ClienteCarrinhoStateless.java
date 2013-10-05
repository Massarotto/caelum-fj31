package br.com.caelum.loja.client.exemplo;

import javax.naming.InitialContext;

import br.com.caelum.loja.entity.Livro;
import br.com.caelum.loja.session.Carrinho;

public class ClienteCarrinhoStateless {
	
	public static void main(String[] args) throws Exception {
		InitialContext ic = new InitialContext();
		Carrinho c = (Carrinho) ic.lookup("ejb:fj31-loja-ear/fj31-loja-ejb3/CarrinhoBean!br.com.caelum.loja.session.Carrinho");
		
		Livro l1 = new Livro();
		l1.setNome("Pais e Filhos");
		l1.setPreco(100.0);
		
		c.addLivro(l1);
		
		for(Livro v : c.getLivros()) {
			System.out.println(v.getNome());
		}
	}
	
}
