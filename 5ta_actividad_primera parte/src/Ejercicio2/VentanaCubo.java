package Ejercicio2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaCubo extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel Lado, Volumen, Superficie;
    private JTextField CampoLado;
    private JButton Calcular;

    public VentanaCubo() {
        setTitle("Cubo");
        setSize(280, 200);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        initializeComponents();
    }

    private void initializeComponents() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        Lado = new JLabel("Lado (cms):");
        Lado.setBounds(20, 20, 135, 23);
        CampoLado = new JTextField();
        CampoLado.setBounds(100, 20, 135, 23);

        Calcular = new JButton("Calcular");
        Calcular.setBounds(100, 50, 135, 23);
        Calcular.addActionListener(this);

        Volumen = new JLabel("Volumen (cm3):");
        Volumen.setBounds(20, 90, 135, 23);
        Superficie = new JLabel("Superficie (cm2):");
        Superficie.setBounds(20, 120, 135, 23);

        contenedor.add(Lado);
        contenedor.add(CampoLado);
        contenedor.add(Calcular);
        contenedor.add(Volumen);
        contenedor.add(Superficie);
    }

    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == Calcular) {
            boolean error = false;
            try {
                double lado = Double.parseDouble(CampoLado.getText());
                Cubo cubo = new Cubo(lado);
                Volumen.setText("Volumen (cm3): " + String.format("%.2f", cubo.calcularVolumen()));
                Superficie.setText("Superficie (cm2): " + String.format("%.2f", cubo.calcularSuperficie()));
            } catch (NumberFormatException e) {
                error = true;
            } finally {
                if (error) {
                    JOptionPane.showMessageDialog(null, "Campo nulo o error en formato de número", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}

