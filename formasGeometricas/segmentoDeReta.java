package com.example.josue.exercicio4.formasGeometricas;

public class segmentoDeReta {
    private ponto2D P1;
    private ponto2D P2;
    private int cor;


    public segmentoDeReta(ponto2D p1, ponto2D p2, int color) {
        P1 = p1;
        P2 = p2;
        cor = color;
    }


    public void alterarCor(int color) {
        cor = color;
    }

    public int rotornarCor() {
        return cor;
    }

    public void setP1(ponto2D p1) {
        P1 = p1;
    }

    public void setP2(ponto2D p2) {
        P2 = p2;
    }

    public ponto2D getP1() {
        return P1;
    }

    public ponto2D getP2() {
        return P2;
    }
}