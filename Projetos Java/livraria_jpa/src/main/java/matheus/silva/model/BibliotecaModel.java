package matheus.silva.model;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class BibliotecaModel {
    private EntityManagerFactory emf;
    private EntityManager em;


    public BibliotecaModel() {
        emf = Persistence.createEntityManagerFactory("bibliotecaPU");
        em = emf.createEntityManager();
    }


    public void adicionarLivro(LivroModel livro) {
        em.getTransaction().begin();
        em.persist(livro);
        em.getTransaction().commit();
    }


    public LivroModel buscarLivroPorTitulo(String titulo) {
        List<LivroModel> livros = em.createQuery("SELECT l FROM livro l WHERE l.titulo = :titulo", LivroModel.class)
                .setParameter("titulo", titulo)
                .getResultList();
        return livros.isEmpty() ? null : livros.get(0);
    }


    public List<LivroModel> listarLivros() {
        return em.createQuery("SELECT l FROM livro l", LivroModel.class).getResultList();
    }
}
