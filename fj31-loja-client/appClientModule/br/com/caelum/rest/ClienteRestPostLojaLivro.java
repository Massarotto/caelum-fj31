package br.com.caelum.rest;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public class ClienteRestPostLojaLivro {
	
	public static void main(String[] args) throws ClientProtocolException, IOException {
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost("http://localhost:8080/fj31-loja-rest/loja/livros");
		post.addHeader("content-type", "application/xml");
		
		StringEntity xml = new StringEntity("<livro><nome>Jim Webber</nome><preco>66.9</preco></livro>");
		post.setEntity(xml);
		
		HttpResponse response = client.execute(post);
		
		System.out.println(response.getStatusLine());
		System.out.println(response.getFirstHeader("Location"));
	}
	
}
