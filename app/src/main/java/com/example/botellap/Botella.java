package com.example.botellap;

public class Botella {

    private Integer caudal;

    public Botella() {
        caudal = 0;
    }

    public void cargar100(String aviso) {
        caudal += 100;
        aviso = caudal.toString();
    }

}

