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
}
