package umu.pds.ProyectoPDS.modelo;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_ejercicio")
public abstract class Ejercicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String enunciado;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;
    
    public Ejercicio() {}
    
    public Ejercicio(String enunciado, Curso curso) {
        this.enunciado = enunciado;
        this.curso = curso;
    }

	public Long getId() {
		return id;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

    
}