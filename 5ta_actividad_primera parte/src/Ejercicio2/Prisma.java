package Ejercicio2;

public class Prisma extends FiguraGeometrica {
    private double b;
    private double h;
    private double p;

    public Prisma(double base, double altura, double profundidad) {
        this.b = base;
        this.h = altura;
        this.p = profundidad;
        this.setVolumen(calcularVolumen());
        this.setSuperficie(calcularSuperficie());
    }

    public double calcularVolumen() {
        double volumen = b * h * p;
        return volumen;
    }

    public double calcularSuperficie() {
        double superficie = 2 * (b * h + b * p + h * p);
        return superficie;
    }
}

