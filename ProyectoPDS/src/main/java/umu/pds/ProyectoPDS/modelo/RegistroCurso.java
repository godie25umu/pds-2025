package umu.pds.ProyectoPDS.modelo;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
public class RegistroCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    private double progreso;
    private LocalDate fechaInscripcion;

    public RegistroCurso() {}

    public RegistroCurso(Usuario usuario, Curso curso, double progreso, LocalDate fechaInscripcion) {
        this.usuario = usuario;
        this.curso = curso;
        this.progreso = progreso;
        this.fechaInscripcion = fechaInscripcion;
    }
	public LocalDate getFechaInscripcion() {
		return fechaInscripcion;
	}
	public void setFechaInscripcion(LocalDate fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}
	public double getProgreso() {
		return progreso;
	}
	public void setProgreso(double progreso) {
		this.progreso = progreso;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	} 

}
