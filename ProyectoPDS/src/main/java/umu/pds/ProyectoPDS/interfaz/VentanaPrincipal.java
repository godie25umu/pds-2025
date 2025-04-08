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
    private JLabel lblBienvenido;
    private JLabel lblCurso;
    private JLabel lblConfiguracion;
    private JLabel lblSalir;
    private JLabel lblLogros;

    public VentanaPrincipal() {

        int delay = 3000;

        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (lblBienvenido != null) {
                    lblBienvenido.setText("AprendeDivertido3000");
                }
            }
        };

        Timer timer = new Timer(delay, taskPerformer);

        timer.setRepeats(false);

        timer.start();



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
                System.exit(0);
            }
        });
        lblConfiguracion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Label Configuracion Clicada");
            }
        });
    }

    public JPanel getPanelPrincipal() {
        return panel1;
    }
}