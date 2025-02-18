package infra;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class DAO<E> {

	private static EntityManagerFactory emf;
	private	 EntityManager em;
	private Class<E> classe;

	// Bloco STATIC executa uma vez ao carregar a classe no jvm
	static {
		try {
			emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//Construtor está usando o construtor de baixo.
	public DAO() {
		this(null);
	}

	// Recebe uma classe, cria o em e armazena a classe
	public DAO(Class<E> classe) {
		em = emf.createEntityManager();
		this.classe = classe;
	}
	
	public DAO<E> abrirT(){
		em.getTransaction().begin();
		return this;
	}
	
	public DAO<E> fecharT(){
		em.getTransaction().commit();
		return this;
	}
	
	public DAO<E> incluir(E entidade){
		em.persist(entidade);
		return this;
	}
	
	public DAO<E> inserirAtomico(E entidade){
		return this.abrirT().incluir(entidade).fecharT();
	}
	
	public E findById(Object id) {
		return em.find(classe, id);
	}
	
	// usa o obter todos de baixo, 
	public List<E> obterTodos() {
		return this.obterTodos(10, 0);
	}
	
	public List<E> obterTodos(int qtde, int deslocamento){
		if (classe == null) {
			throw new UnsupportedOperationException("Classe nula");
		} 
		String jpql = "SELECT e from " + classe.getName() + " e";
		TypedQuery<E> query = em.createQuery(jpql, classe);
		query.setMaxResults(qtde);
		query.setFirstResult(deslocamento);
		return query.getResultList();
		
	}
	
	
	
	public List<E> consultar(String nomeConsulta, Object ... params){
		TypedQuery<E> query = em.createNamedQuery(nomeConsulta, classe);
		
		for(int i = 0; i < params.length; i += 2) {
			query.setParameter(params[i].toString(), params[i + 1]);
		}		
		return query.getResultList();
	}
	
	public E consultarUm(String nomeConsulta, Object...params) {
		List<E> lista = consultar(nomeConsulta, params);
		if (lista != null) {
			return lista.getFirst();
		} else {
			throw new NullPointerException("Null Result");
		}		
	}
	
//	public List<E> consultar(String nomeConsulta, Object um, Object dois){
//		TypedQuery<E> query = em.createNamedQuery(nomeConsulta, classe);		
//		
//		query.setParameter(um.toString(), dois);
//				
//		return query.getResultList();
//	}
	
	
//	public List<Filme> findFilmeFilterNota(Double nota) {
//		return this.em.createNamedQuery("FindByNotaMaiorQue", Filme.class)
//				.setParameter("nota", nota)
//				.getResultList();
//	}
	
	public void fechar() {
		em.close();
	}
}
