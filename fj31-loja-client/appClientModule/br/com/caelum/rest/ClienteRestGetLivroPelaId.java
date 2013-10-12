package br.com.caelum.rest;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class ClienteRestGetLivroPelaId {
	
	public static void main(String[] args) throws IllegalStateException, IOException {
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet get = new HttpGet("http://localhost:8080/fj31-loja-rest/loja/livro/2");
		get.addHeader("accept", "application/json");
		
		HttpResponse response = httpClient.execute(get);
		InputStream contenc = response.getEntity().getContent();
		
		Scanner scanner = new Scanner(contenc);
		while(scanner.hasNextLine()) {
			System.out.println(scanner.nextLine());
		}
		contenc.close();
		
	}
	
}
