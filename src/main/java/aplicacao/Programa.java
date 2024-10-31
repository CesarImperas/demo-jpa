package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		
		Pessoa p1 = new Pessoa(null, "Carlos da Silva", "carlos@gmail.com");
		Pessoa p2 = new Pessoa(null, "Joaquim", "joaquim@gmail.com");
		Pessoa p3 = new Pessoa(null, "Ana", "ana@gmail.com");
		
		// Nome da JPA (configurada no arquivo persistence.xml
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		
		// Criação da EntityManager
		EntityManager em = emf.createEntityManager();
		
		// Iniciar uma transação com o banco de dados
		em.getTransaction().begin();
		
		// Pega o objeto e guarda no banco de dados
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		
		// Término da transação
		em.getTransaction().commit();
		
		System.out.println("Pronto!");

	}
}
