package com.example.botellap;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

    Botella botella = new Botella();

    @BindView(R.id.visor)
    TextView visor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.cargador)
    public void onViewClicked() {
        botella.cargar100(visor);
    }


    /*
    @OnClick(R.id.cargador)
    public void onViewClicked() {
        String visor_text = visor.getText().toString();
        botella.cargar100(visor_text);
    }*/
}
