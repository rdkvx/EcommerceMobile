package com.example.javae_commerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnVendedor, btnComprador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnVendedor = (Button) findViewById(R.id.btnVendedor);
        btnComprador = (Button) findViewById(R.id.btnComprador);


        btnVendedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btnVendedorActivity();

            }
        });

        btnComprador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btnCompradorActivity();

            }
        });

    }

    private void btnVendedorActivity() {

        startActivity(new Intent(MainActivity.this, AutenVend.class));

    }

    private void btnCompradorActivity() {

        startActivity(new Intent(MainActivity.this, PainelC.class));
    }


}