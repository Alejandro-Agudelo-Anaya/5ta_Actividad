package Ejercicio2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaPrisma extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel base, altura, profundidad, volumen, superficie;
    private JTextField Campobase, Campoaltura, Campoprofundidad;
    private JButton calcular;

    public VentanaPrisma() {
        inicio();
        setTitle("Prisma");
        setSize(280, 250);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        base = new JLabel("Base (cm):");
        base.setBounds(20, 20, 100, 23);
        Campobase = new JTextField();
        Campobase.setBounds(130, 20, 120, 23);

        altura = new JLabel("Altura (cm):");
        altura.setBounds(20, 50, 100, 23);
        Campoaltura = new JTextField();
        Campoaltura.setBounds(130, 50, 120, 23);

        profundidad = new JLabel("Profundidad (cm):");
        profundidad.setBounds(20, 80, 100, 23);
        Campoprofundidad = new JTextField();
        Campoprofundidad .setBounds(130, 80, 120, 23);

        calcular = new JButton("Calcular");
        calcular.setBounds(100, 120, 100, 23);
        calcular.addActionListener(this);

        volumen = new JLabel("Volumen (cm^3):");
        volumen.setBounds(20, 160, 200, 23);
        superficie = new JLabel("Superficie (cm^2):");
        superficie.setBounds(20, 190, 200, 23);

        contenedor.add(base);
        contenedor.add(Campobase);
        contenedor.add(altura);
        contenedor.add(Campoaltura);
        contenedor.add(profundidad);
        contenedor.add(Campoprofundidad);
        contenedor.add(calcular);
        contenedor.add(volumen);
        contenedor.add(superficie);
    }

    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == calcular) {
            boolean error = false;
            try {
                double base = Double.parseDouble(Campobase.getText());
                double altura = Double.parseDouble(Campoaltura.getText());
                double profundidad = Double.parseDouble(Campoprofundidad.getText());
                Prisma prisma = new Prisma(base, altura, profundidad);
                volumen.setText("Volumen (cm3): " + String.format("%.2f", prisma.getVolumen()));
                superficie.setText("Superficie (cm2): " + String.format("%.2f", prisma.getSuperficie()));
            } catch (Exception e) {
                error = true;
            } finally {
                if (error) {
                    JOptionPane.showMessageDialog(null, "Campo nulo o error en formato de número", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
