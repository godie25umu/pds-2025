package umu.pds.ProyectoPDS.interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaPrincipal {

    private JPanel panel1;
    private JLabel lblBienvenido;
    private JLabel lblCurso;
    private JLabel lblLogros;
    private JLabel lblConfiguracion;
    private JLabel lblSalir;

    public VentanaPrincipal() {
        // Crear el panel principal con BorderLayout
        panel1 = new JPanel(new BorderLayout());

        // ========== Panel Norte ==========
        JPanel panelNorth = new JPanel(new BorderLayout(0, 10));
        lblBienvenido = new JLabel("Bienvenido", SwingConstants.CENTER);
        lblBienvenido.setFont(new Font("Inter", Font.PLAIN, 26));
        panelNorth.add(lblBienvenido, BorderLayout.CENTER);
        panel1.add(panelNorth, BorderLayout.NORTH);

        // ========== Panel Central ==========
        JPanel panelCenter = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Espaciador horizontal (columna 1)
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 120;
        panelCenter.add(Box.createHorizontalStrut(120), gbc);

        // Espaciador vertical (fila 1)
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.ipady = 120;
        panelCenter.add(Box.createVerticalStrut(120), gbc);

        // Label "Cursos" (fila 0, columna 0)
        lblCurso = new JLabel("Cursos");
        lblCurso.setFont(new Font("Inter", Font.PLAIN, 18));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        panelCenter.add(lblCurso, gbc);

        // Label "Logros" (fila 0, columna 2)
        lblLogros = new JLabel("Logros");
        lblLogros.setFont(new Font("Inter", Font.PLAIN, 18));
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        panelCenter.add(lblLogros, gbc);

        // Label "Configuración" (fila 2, columna 0)
        lblConfiguracion = new JLabel("Configuración");
        lblConfiguracion.setFont(new Font("Inter", Font.PLAIN, 18));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        panelCenter.add(lblConfiguracion, gbc);

        // Label "Salir" (fila 2, columna 2)
        lblSalir = new JLabel("Salir");
        lblSalir.setFont(new Font("Inter", Font.PLAIN, 18));
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        panelCenter.add(lblSalir, gbc);

        panel1.add(panelCenter, BorderLayout.CENTER);

        // ========== Lógica del temporizador ==========
        Timer timer = new Timer(3000, e -> lblBienvenido.setText("AprendeDivertido3000"));
        timer.setRepeats(false);
        timer.start();

        // ========== Listeners ==========
        addLabelListeners();
    }

    private void addLabelListeners() {
        // Opcional: cambiar cursor
        Cursor hand = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);

        lblCurso.setCursor(hand);
        lblCurso.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.out.println("Label Curso Clicada");
            }
        });

        lblLogros.setCursor(hand);
        lblLogros.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.out.println("Label Logros Clicada");
            }
        });

        lblConfiguracion.setCursor(hand);
        lblConfiguracion.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.out.println("Label Configuracion Clicada");
            }
        });

        lblSalir.setCursor(hand);
        lblSalir.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.out.println("Label Salir Clicada");
                System.exit(0);
            }
        });
    }

    public JPanel getPanelPrincipal() {
        return panel1;
    }
}
