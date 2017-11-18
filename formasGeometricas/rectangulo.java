package com.example.josue.exercicio4.formasGeometricas;

/**
 * Created by josue on 10/10/2017.
 */

public class rectangulo {
    ponto2D p1;
    double alt;
    double comp;

    public rectangulo() {
        p1 = new ponto2D();
        alt = Math.floor(Math.random() * 20 + 1);
        comp = Math.floor(Math.random() * 20 + 1);
    }

    public rectangulo(ponto2D p1) {
        this.p1 = p1;
        alt = Math.floor(Math.random() * 20 + 1);
        comp = Math.floor(Math.random() * 20 + 1);
    }

    public rectangulo(ponto2D p1, double altura, double comprimento) {
        this.p1 = p1;
        this.alt = altura;
        this.comp = comprimento;
    }

    public double retornarArea() {
        double area;
        area = comp * alt;
        return area;
    }

    public double retornarPerimetro() {
        double per;
        per = (2 * alt) + (2 * comp);
        return per;
    }
}
