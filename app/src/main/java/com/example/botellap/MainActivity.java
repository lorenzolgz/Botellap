package com.example.botellap;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

    Botella botella;

    @BindView(R.id.visor)
    TextView visor;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            // Restore value of members from saved state
            Integer caudal_viejo = savedInstanceState.getInt("old");
            botella = new Botella(caudal_viejo);
        } else {
            // Probably initialize members with default values for a new instance
            botella = new Botella(0);
        }

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        botella.actualizarVisor(visor);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Integer caudal_viejo = 99;

        FileInputStream fin = null;
        try {
            fin = openFileInput("prueba.txt");

            int c;
            String temp="";
            while( (c = fin.read()) != -1){
                temp = temp + Character.toString((char)c);
            }
            fin.close();

            caudal_viejo = Integer.parseInt(temp);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        botella = new Botella(caudal_viejo);
        botella.actualizarVisor(visor);

    }

    public void backup_caudal(Botella botella){

        Integer caudal_backup = botella.getCaudal();

        FileOutputStream fOut = null;
        try {
            fOut = openFileOutput("prueba.txt", Context.MODE_PRIVATE);
            String str = caudal_backup.toString();
            fOut.write(str.getBytes());
            fOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @OnClick(R.id.cargador)
    public void onViewClicked() {
        botella.cargar100(visor);
        backup_caudal(botella);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_settings:
                botella = new Botella();
                botella.actualizarVisor(visor);
                backup_caudal(botella);
                break;
            default:
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}