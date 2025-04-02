package umu.pds.ProyectoPDS.modelo;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<RegistroCurso> cursosInscritos;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
		
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	public void agregarCurso(RegistroCurso registro) {
	    this.cursosInscritos.add(registro);
	    registro.setUsuario(this);
	}

	public void eliminarCurso(RegistroCurso registro) {
	    this.cursosInscritos.remove(registro);
	    registro.setUsuario(null);
	}

}