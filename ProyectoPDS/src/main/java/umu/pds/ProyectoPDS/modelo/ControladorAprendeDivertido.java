package umu.pds.ProyectoPDS.modelo;

import java.awt.EventQueue;
import java.util.HashMap;


import jakarta.persistence.EntityManager;
import umu.pds.ProyectoPDS.interfaz.VentanaLogin;
import umu.pds.ProyectoPDS.repositorio.RepositorioCurso;


public class ControladorAprendeDivertido {
	private RepositorioCurso repositorio;
	private Usuario usuarioActual;
	private EntityManager en;


	public ControladorAprendeDivertido() {
		repositorio = new RepositorioCurso(en);
		usuarioActual = new Usuario();
		
	}
	
	public Usuario getUsuarioActual() {
		return usuarioActual;
	}
	
	
	public void CargarPantalladeLoginRegistro() {
		System.out.println("hola?");
		VentanaLogin window = new VentanaLogin();

		
	}
	public void CargarAplicacion() {
		System.out.println("Aplicacion cargada");
		//Cargar aplicacion para el usuario actual
	}
	
	}
