package br.com.caelum.loja.session;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.caelum.loja.entity.Livro;
import br.com.caelum.loja.ws.ConsultaDeLivros;

@WebService
@Stateless @Remote(ConsultaDeLivros.class)
public class ConsultaDeLivrosBean implements ConsultaDeLivros{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	@WebMethod
	public List<Livro> buscaLivro(@WebParam(name="nome") String nome) {
		Query query = manager.createQuery("select l from Livro l left join fetch l.autores a where l.nome like :nome")
				.setParameter("nome", "%"+nome+"%");
		return query.getResultList();
	}
	
	
	
}
