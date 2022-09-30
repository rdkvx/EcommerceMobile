package com.example.javae_commerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PainelV extends AppCompatActivity {

    private Button btnCadProd, btnChecarProduto, btnVendasEfetuadas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_painelv);

        btnChecarProduto = (Button) findViewById(R.id.btnChecarProduto);
        btnCadProd = (Button) findViewById(R.id.btnCadProd);
        btnVendasEfetuadas = (Button) findViewById(R.id.btnVendasEfetuadas);




        btnCadProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btnCadProdActivity();
            }
        });


        btnChecarProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btnChecarProdutoActivity();
            }
        });

        btnVendasEfetuadas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btnVendasEfetuadasActivity();

            }
        });

    }

    private void btnVendasEfetuadasActivity() {

        startActivity(new Intent(PainelV.this, VendEfet.class));
    }

    private void btnChecarProdutoActivity() {

        startActivity(new Intent(PainelV.this, Envios.class));
    }

    private void btnCadProdActivity() {

        startActivity(new Intent(PainelV.this, Produtos.class));
    }
}