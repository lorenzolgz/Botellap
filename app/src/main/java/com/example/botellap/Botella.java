package com.example.botellap;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Botella {

    private Integer caudal;
    private Integer capacidad = 2000;

    public Botella() {
        caudal = 0;
    }

    public Botella(Integer caudal_viejo) {
        caudal = caudal_viejo;
    }

    public void actualizarVisor(TextView visor){
        visor.setText(caudal.toString());
    }

    public void cargar100(TextView visor) {
        caudal += 100;
        visor.setText(caudal.toString());
    }

    public void backupCaudal(Context context){

        Integer caudal_backup = this.caudal;

        FileOutputStream fOut = null;
        try {
            fOut = context.openFileOutput("prueba.txt", Context.MODE_PRIVATE);
            String str = caudal_backup.toString();
            fOut.write(str.getBytes());
            fOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getCaudal() {
        return caudal;
    }

    public int getNivel(){return (caudal*5) / capacidad;}
}
