package prueba;

import jakarta.persistence.*;
import umu.pds.ProyectoPDS.modelo.*;

public class TestJPA {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pds2025");
        
        EntityManager em = emf.createEntityManager();
        
        try {
            em.getTransaction().begin();
            Usuario usuario = new Usuario();
            usuario.setNombre("Ejemplo");
            em.persist(usuario);
            em.getTransaction().commit();
            Usuario usuarioGuardado = em.find(Usuario.class, usuario.getId());
            System.out.println("Usuario guardado: " + usuarioGuardado.getNombre());
            
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
            if (emf != null && emf.isOpen()) {
                emf.close(); 
            }
        }
    }
}