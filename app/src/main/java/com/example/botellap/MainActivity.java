package com.example.botellap;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.BindView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.visor)
    TextView visor;
    Botella botella = new Botella();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.cargador)
    public void onViewClicked() {
        String visor_text = visor.getText().toString();
        botella.cargar100(visor_text);
    }
}
