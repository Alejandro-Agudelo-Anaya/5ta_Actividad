package Ejercicio2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Cubo extends FiguraGeometrica {
    private double l;

    public Cubo(double lado) {
        this.l = lado;
        this.setVolumen(calcularVolumen());
        this.setSuperficie(calcularSuperficie());
    }

    public double calcularVolumen() {
        double volumen = Math.pow(l,3);
        return volumen;
    }

    public double calcularSuperficie() {
        double superficie = 6* Math.pow(l,2);
        return superficie;
    }

}
