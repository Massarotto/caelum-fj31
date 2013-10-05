package br.com.caelum.loja.client.exemplo;

import javax.naming.InitialContext;

import br.com.caelum.loja.session.Agendador;

public class ClienteAgendador {
	
	public static void main(String[] args) throws Exception {
		InitialContext ic = new InitialContext();
		
		Agendador agendador = (Agendador) ic.lookup("ejb:fj31-loja-ear/fj31-loja-ejb3/AgendadorBean!br.com.caelum.loja.session.Agendador");
		
		agendador.agenda("*/1", "20");
	}
	
}
