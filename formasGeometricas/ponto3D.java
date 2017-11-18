package com.example.josue.exercicio4.formasGeometricas;


public class ponto3D extends ponto2D {
    public double z;

    public ponto3D() {
        x = Math.floor(Math.random() * 20 + 1);
        y = Math.floor(Math.random() * 20 + 1);
        z = Math.floor(Math.random() * 20 + 1);
    }

    public ponto3D(double x1, double y1, double z1) {
        x = x1;
        y = y1;
        z = z1;
    }

    @Override
    public double distanciaCentro() {
        double hipotenusa3D = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
        return hipotenusa3D;
    }

    public double distanciaPontos(ponto3D p2) {
        double x3 = this.x - p2.x;
        double y3 = this.y - p2.y;
        double z3 = this.z - p2.z;

        double hipotenusa3D = Math.sqrt(Math.pow(x3, 2) + Math.pow(y3, 2) + Math.pow(z3, 2));
        return hipotenusa3D;
    }

    public static void addPontos(ponto3D p2, int kx, int ky, int kz) {
        p2.x = p2.x + kx;
        p2.y = p2.y + ky;
        p2.z = p2.z + kz;

    }

    public static void addPontos(ponto3D p2, int k) {
        p2.x = p2.x + k;
        p2.y = p2.y + k;
        p2.z = p2.z + k;

    }

    public static boolean mesmasCoordenadas(ponto3D p, ponto3D p2) {
        boolean resultado = false;

        if (p.x == p2.x && p.y == p2.y && p.z == p2.z) {
            resultado = true;
        }
        return resultado;
    }
}
