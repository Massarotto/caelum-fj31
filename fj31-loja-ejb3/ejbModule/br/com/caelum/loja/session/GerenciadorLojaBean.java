package br.com.caelum.loja.session;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.loja.entity.Autor;
import br.com.caelum.loja.entity.Livro;
import br.com.caelum.loja.exception.SalvaLivroException;
import br.com.caelum.loja.interceptor.AuditoriaInterceptor;

@Stateless
@Remote(GerenciadorLoja.class)
@Interceptors(AuditoriaInterceptor.class)
public class GerenciadorLojaBean implements GerenciadorLoja {
	
	@PersistenceContext
	private EntityManager em;
	
	private Map<String, Livro> repositorio;
	
	public GerenciadorLojaBean() {
		this.repositorio = new HashMap<String, Livro>();
		
		Livro l1 = new Livro();
		l1.setNome("Pais e Filhos");
		l1.setPreco(100.0);
		
		Livro l2 = new Livro();
		l2.setNome("Noites brancas");
		l2.setPreco(200.0);
		
		this.repositorio.put("1111", l1);
		this.repositorio.put("2222", l2);
	}

	@Override
	public Livro procura(String isbn) {
		return this.repositorio.get(isbn);
	}

	@Override
	public Livro salva(Livro livro) {
		this.em.persist(livro);
		System.out.println("Livro salvo! ID: " + livro.getId());
		return livro;
	}
	
	@Override
	public Autor salva(Autor autor) {
		this.em.persist(autor);
		System.out.println(autor.getId());
		return autor;
	}

	@Override
	public Livro procura(Long id) {
		return this.em.find(Livro.class, id);
	}

	@Override
	public List<Livro> listarLivros() {
		return this.em.createQuery("select l from Livro l join fetch l.autores").getResultList();
	}

}
