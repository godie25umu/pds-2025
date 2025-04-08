package umu.pds.ProyectoPDS.interfaz;

import javax.swing.*;
// Importa las clases necesarias para el Timer
import javax.swing.Timer; // Asegúrate de que sea javax.swing.Timer
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// Resto de tus imports...
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaPrincipal {
    private JPanel panel1;
    private JPanel panelNorth;
    private JLabel lblBienvenido; // El label que queremos ocultar
    private JLabel lblCurso;
    private JLabel lblConfiguracion;
    private JLabel lblSalir;
    private JLabel lblLogros;

    public VentanaPrincipal() {
        // --- INICIO: Código para ocultar lblBienvenido después de 3 segundos ---

        // 1. Define el retraso en milisegundos (3 segundos = 3000 ms)
        int delay = 3000;

        // 2. Crea el ActionListener que se ejecutará cuando el timer termine
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                // Esta es la acción que se realiza pasados los 3 segundos:
                if (lblBienvenido != null) { // Buena práctica: comprobar que no sea null
                    lblBienvenido.setText("AprendeDivertido3000");
                }
            }
        };

        // 3. Crea el Timer
        Timer timer = new Timer(delay, taskPerformer);

        // 4. Configura el timer para que se ejecute solo una vez
        timer.setRepeats(false);

        // 5. Inicia el timer
        timer.start();

        // --- FIN: Código para ocultar lblBienvenido ---


        // --- Tu código existente de listeners ---
        lblCurso.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Label Curso Clicada");
            }
        });
        lblLogros.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Label Logros Clicada");
            }
        });
        lblSalir.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Label Salir Clicada");
                // Código para cerrar la aplicación
                System.exit(0);
            }
        });
        lblConfiguracion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Label Configuracion Clicada");
            }
        });
        // ... resto de tu constructor si hubiera más código ...
    }

    // Tu método getter (asegúrate de que sigue aquí)
    public JPanel getPanelPrincipal() {
        return panel1;
    }
}