package com.example.josue.exercicio4.formasGeometricas;

import java.util.Vector;

public class ponto2D {
    public double x;
    public double y;

    public ponto2D() {
        x = Math.floor(Math.random() * 20 + 1);
        y = Math.floor(Math.random() * 20 + 1);
    }

    public ponto2D(ponto2D p) {
        x = p.x + Math.floor(Math.random() * 20 + 1);
        y = p.y + Math.floor(Math.random() * 20 + 1);
    }

    public ponto2D(int xx, int yy) {
        x = xx;
        y = yy;
    }

    public static Vector<ponto2D> createPontos(ponto2D p) {
        Vector<ponto2D> pontos = new Vector<>();
        for (int i = 0; i < 10; i++) {
            pontos.add(i, new ponto2D(p));
        }
        return pontos;
    }

    public static boolean mesmasCoordenadas(ponto2D p, ponto2D p2) {
        boolean resultado = false;

        if (p.x == p2.x && p.y == p2.y) {
            resultado = true;
        }
        return resultado;
    }

    public double distanciaCentro() {
        double hipotenusa = Math.sqrt(Math.pow(x, 2) + (Math.pow(y, 2)));
        return hipotenusa;
    }

    public double distanciaPontos(ponto2D p2) {
        double x3 = this.x - p2.x;
        double y3 = this.y - p2.y;

        double hipotenusa = Math.sqrt(Math.pow(x3, 2) + (Math.pow(y3, 2)));
        return hipotenusa;
    }

    public void setX(double xx) {
        x = xx;
    }

    public void setY(double yy) {
        y = yy;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

}
