package umu.pds.ProyectoPDS.repositorio;

import jakarta.persistence.EntityManager;
import umu.pds.ProyectoPDS.modelo.*;

public class RepositorioCurso {
    private EntityManager em;

    public RepositorioCurso(EntityManager em) {
        this.em = em;
    }

    public void guardarCurso(Curso curso) {
        em.getTransaction().begin();
        em.persist(curso);
        em.getTransaction().commit();
    }

    public Curso buscarPorId(Long id) {
        return em.find(Curso.class, id);
    }
    
    public void actualizarCurso(Curso curso) {
        em.getTransaction().begin();
        em.merge(curso);
        em.getTransaction().commit();
    }

    public void eliminarCurso(Long id) {
        em.getTransaction().begin();
        Curso curso = em.find(Curso.class, id);
        if (curso != null) {
            em.remove(curso);
        }
        em.getTransaction().commit();
    }
}
