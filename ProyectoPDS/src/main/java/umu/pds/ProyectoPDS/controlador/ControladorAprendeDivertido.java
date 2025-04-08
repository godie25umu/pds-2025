package umu.pds.ProyectoPDS.controlador;


import jakarta.persistence.EntityManager;
import umu.pds.ProyectoPDS.interfaz.VentanaLogin;
import umu.pds.ProyectoPDS.interfaz.VentanaPrincipal;
import umu.pds.ProyectoPDS.modelo.Usuario;
import umu.pds.ProyectoPDS.repositorio.RepositorioCurso;

import javax.swing.*;


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
		//VentanaLogin window = new VentanaLogin();
		JFrame frame = new JFrame("Mi Aplicación Principal"); // Ponle un título
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Acción al cerrar

		frame.setSize(800, 600); // Ancho x Alto

		frame.setResizable(false);

		// 2. Crear una instancia de tu panel diseñado
		VentanaPrincipal panelContenido = new VentanaPrincipal();

		// 3. Obtener el panel raíz de tu diseño
		JPanel panelPrincipal = panelContenido.getPanelPrincipal(); // Usar el getter

		// 4. Establecer ese panel como el contenido del JFrame
		frame.setContentPane(panelPrincipal);
		// O alternativamente: frame.add(panelPrincipal); (si el layout del frame es simple)


		// Opcional: Centrar la ventana en la pantalla
		frame.setLocationRelativeTo(null);

		// 6. Hacer visible la ventana ¡Este es el paso clave!
		frame.setVisible(true);

		
	}
	public void CargarAplicacion() {
		System.out.println("Aplicacion cargada");
		//Cargar aplicacion para el usuario actual
	}
	
	}
