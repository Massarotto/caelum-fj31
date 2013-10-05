package br.com.caelum.loja.client.exemplo;

import br.com.caelum.loja.entity.Livro;

public class ClienteFazendoChamadaLocal {
	public static void main(String[] args) {
		Livro l1 = new Livro();
		l1.setNome("GTA V");
		l1.setPreco(200.0);
			
		long inicio = System.currentTimeMillis();
		for(int i = 0; i < 10000; i++) {
			l1.getPreco();
		}
		long fim = System.currentTimeMillis();
		System.out.println(fim - inicio);
	}
}
