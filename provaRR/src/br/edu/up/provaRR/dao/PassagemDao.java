package br.edu.up.provaRR.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.up.provaRR.entity.Passagem;

public class PassagemDao {

	public void salvar(Passagem pass) {
		EntityManager emf = Conexao.getInstance().createEntityManager();
		emf.getTransaction().begin();
		emf.persist(pass);
		emf.getTransaction().commit();
		
	}
	
	public ArrayList<Passagem> listar(){
		EntityManager emf = Conexao.getInstance().createEntityManager();
		Query q = emf.createQuery("from Passagem");
		
		return new ArrayList<Passagem>(q.getResultList());
	}
	
	public void alterar(Passagem pass) {
		EntityManager emf = Conexao.getInstance().createEntityManager();
		emf.getTransaction().begin();
		emf.merge(pass);
		emf.getTransaction().commit();
	}
	
	public void remover(Integer id) {
		EntityManager emf = Conexao.getInstance().createEntityManager();
		emf.getTransaction().begin();
		Passagem pass = emf.find(Passagem.class, id);
		emf.remove(pass);
		emf.getTransaction().commit();
	}
	
}
