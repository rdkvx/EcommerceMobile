package com.example.javae_commerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.button.MaterialButtonToggleGroup;

public class PainelC extends AppCompatActivity {

    private Button btnListProd, btnEnvioCompr, btnCompra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_painelc);

        btnCompra = (Button) findViewById(R.id.btnCompra);
        btnEnvioCompr = (Button) findViewById(R.id.btnEnvioCompr);
        btnListProd = (Button) findViewById(R.id.btnListProd);


        btnListProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btnListProdActivity();

            }
        });

        btnCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btnCompraActivity();

            }
        });

        btnEnvioCompr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btnEnvioComprActivity();

            }
        });
    }

    private void btnCompraActivity() {

        startActivity(new Intent(PainelC.this, Compras.class));

    }

    private void btnEnvioComprActivity() {

        startActivity(new Intent(PainelC.this, EnvioCompr.class));
    }

    private void btnListProdActivity() {

        startActivity( new Intent(PainelC.this, ListProd.class));
    }
}