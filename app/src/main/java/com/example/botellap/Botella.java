package com.example.botellap;

import android.widget.TextView;

public class Botella {

    private Integer caudal;

    public Botella() {
        caudal = 0;
    }

    public void cargar100(TextView visor) {
        caudal += 100;
        visor.setText(caudal.toString());
    }

}

