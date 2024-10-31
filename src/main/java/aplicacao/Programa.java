package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		
		
		// Nome da JPA (configurada no arquivo persistence.xml
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		
		// Criação da EntityManager
		EntityManager em = emf.createEntityManager();
		
		/* MANEIRA ERRADA (EXCEÇÃO)
		Pessoa p = new Pessoa(2, null, null);
		
		// Remoção de um dado do banco de dados
		em.remove(p);
		
		*/
		
		// MANEIRA CORRETA
		
		Pessoa p = em.find(Pessoa.class, 2);
		
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		
		System.out.println("Pronto!");

		// Fechamento da conexão com o banco de dados
		em.close();
		emf.close();
	}
}
