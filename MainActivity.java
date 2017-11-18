package com.example.josue.exercicio4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.josue.exercicio4.formasGeometricas.*;

import java.util.Vector;

public class MainActivity extends AppCompatActivity {
    DrawView drawView;

    public int constante = 0;
    Vector listaFormas = new Vector();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RelativeLayout rl = (RelativeLayout) findViewById(R.id.rl);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(1000, 1000);
        params.leftMargin = 50;
        params.topMargin = 50;


        drawView = new DrawView(this);
        drawView.setBackgroundColor(Color.GRAY);

        rl.addView(drawView, params);


        drawView.setOnTouchListener(new View.OnTouchListener() {
            //@Override
            public boolean onTouch(View v, MotionEvent event) {
                double x = (double) event.getX();
                double y = (double) event.getY();
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    if (constante == 0) {
                        drawView.pontoInicial.setX(x);
                        drawView.pontoInicial.setY(y);
                        drawView.pontoFinal.setX(x);
                        drawView.pontoFinal.setY(y);
                        drawView.desenhar_quadrado();
                        constante++;
                    } else if (constante == 1) {
                        drawView.pontoFinal.setX(x);
                        drawView.pontoFinal.setY(y);
                        listaFormas.addElement(String.valueOf(drawView.geo));
                        drawView.desenhar_quadrado();
                        constante = 0;
                    }
                }
                return true;
            }
        });

    }


    public void escolhaCores(View v) {
        String string = v.getTag().toString();
        drawView.setColor(Color.parseColor(string));
        drawView.setPaint();
    }

    public void escolhaGeo(View v) {
        String geotemp = v.getTag().toString();
        drawView.setGeo(geotemp);
    }

    public void resetCanvas(View v) {
        drawView.pontoInicial.setX(0);
        drawView.pontoInicial.setY(0);
        drawView.pontoFinal.setX(0);
        drawView.pontoFinal.setY(0);
        constante = 0;
        drawView.desenhar_quadrado();
        listaFormas.clear();
        drawView.listaLine.clear();
        drawView.listaSquare.clear();
        drawView.listaCircle.clear();
    }

}

class DrawView extends View {
    String geo = "line";
    ponto2D pontoInicial;
    ponto2D pontoFinal;
    int color = Color.BLACK;
    Paint paint1;
    Context context;
    Vector listaLine = new Vector();
    Vector listaSquare = new Vector();
    Vector listaCircle = new Vector();
    String temps = "";

    public DrawView(Context context) {
        super(context);
        this.context = context;
        paint1 = new Paint();
        paint1.setStyle(Paint.Style.STROKE);
        paint1.setStrokeWidth(10);
        paint1.setColor(Color.BLACK);
        pontoInicial = new ponto2D(0, 0);
        pontoFinal = new ponto2D(0, 0);
    }

    public void setGeo(String g) {
        this.geo = g;
    }

    public void setPaint() {
        this.paint1.setColor(this.color);
    }

    public void setColor(Integer i) {
        this.color = i;
    }


    public void desenhar_quadrado() {
        invalidate();
    }

    public void desenhar_Inicial(Canvas canvas) {
        float p1 = (float) pontoInicial.getX();
        float p2 = (float) pontoInicial.getY();
        canvas.drawCircle(p1, p2, 1, paint1);
    }

    @Override
    public void onDraw(Canvas canvas) {
        float p1 = (float) pontoInicial.getX();
        float p2 = (float) pontoInicial.getY();
        float p3 = (float) pontoFinal.getX();
        float p4 = (float) pontoFinal.getY();
        ponto2D pontoInicialT = new ponto2D((int) p1, (int) p2);
        ponto2D pontoFinalT = new ponto2D((int) p3, (int) p4);
        float p1c = p1;
        float p2c = p2;
        float temp = 0;
        double dist = 0;

        //FIXME METER A DAR OS CIRCULOS E QUADRADOS

        if (geo.equals("line")) {
            desenhar_Inicial(canvas);

            //FIXME METER AS CORES A FUNCIONAR

            segmentoDeReta Seg = new segmentoDeReta(pontoInicialT, pontoFinalT, paint1.getColor());
            listaLine.addElement(Seg);
            for (int i = 0; i < listaLine.size(); i++) {
                segmentoDeReta Seg1 = (segmentoDeReta) listaLine.elementAt(i);
                float pt1 = (float) Seg1.getP1().getX();
                float pt2 = (float) Seg1.getP1().getY();
                float pt3 = (float) Seg1.getP2().getX();
                float pt4 = (float) Seg1.getP2().getY();
                canvas.drawLine(pt1, pt2, pt3, pt4, paint1);
            }
        } else if (geo.equals("circle")) {
            if (p1 > p3) {
                temp = p1;
                p1 = p3;
                p3 = temp;
            }
            if (p2 > p4) {
                temp = p2;
                p2 = p4;
                p4 = temp;
            }
            double p1t = (double) p1;
            double p2t = (double) p2;
            double p3t = (double) p3;
            double p4t = (double) p4;
            double cat1 = p1t - p3t;
            double cat2 = p2t - p4t;
            dist = Math.sqrt(Math.pow(cat1, 2) + Math.pow(cat2, 2));
            float distf = (float) dist;
            canvas.drawCircle(p1c, p2c, distf, paint1);
            desenhar_Inicial(canvas);
        } else if (geo.equals("square")) {
            if (p1 > p3) {
                temp = p1;
                p1 = p3;
                p3 = temp;
            }
            if (p2 > p4) {
                temp = p2;
                p2 = p4;
                p4 = temp;
            }
            desenhar_Inicial(canvas);
            canvas.drawRect(p1, p2, p3, p4, paint1);
        }

    }
}


