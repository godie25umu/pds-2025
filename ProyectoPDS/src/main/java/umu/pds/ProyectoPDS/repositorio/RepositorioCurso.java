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
}
