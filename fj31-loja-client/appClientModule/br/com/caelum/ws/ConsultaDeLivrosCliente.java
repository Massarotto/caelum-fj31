package br.com.caelum.ws;

import java.util.List;

public class ConsultaDeLivrosCliente {
	
	public static void main(String[] args) {
		ConsultaDeLivrosBean consultaLivros = new ConsultaDeLivrosBeanService().getConsultaDeLivrosBeanPort();
		List<Livro> livros = consultaLivros.buscaLivro("Capitao");
		for(Livro l : livros) {
			System.out.println(l.getNome());
		}
	}
	
}
