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
		
		// Buscar um dado, a partir do seu Id (chave primária)
		// Passando como parâmetro, a classe do objeto retornado, e o Id
		Pessoa p = em.find(Pessoa.class, 2);
		
		System.out.println(p);
		System.out.println("Pronto!");

		// Fechamento da conexão com o banco de dados
		em.close();
		emf.close();
	}
}
