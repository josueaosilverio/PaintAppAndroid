package com.example.josue.exercicio4.formasGeometricas;

/**
 * Created by josue on 10/10/2017.
 */

public class circle extends ponto2D {
    private double r;

    public circle() {
        x = Math.floor(Math.random() * 20 + 1);
        y = Math.floor(Math.random() * 20 + 1);
        r = Math.floor(Math.random() * 20 + 1);
    }

    public circle(double x1, double y1, double r1) {
        x = x1;
        y = y1;
        r = r1;
    }

    public circle(ponto2D p1, double r1) {
        x = p1.x;
        y = p1.y;
        r = r1;
    }

    public double retornarArea() {
        double area;
        area = Math.PI * Math.pow(r, 2);
        return area;
    }

    public double retornarPerimetro() {
        double per;
        per = 2 * Math.PI * r;
        return per;
    }
}
