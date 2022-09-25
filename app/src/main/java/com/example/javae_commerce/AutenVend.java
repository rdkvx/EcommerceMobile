package com.example.javae_commerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AutenVend extends AppCompatActivity {

    private Button btnLoginVend, btnCadVend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auten_vend);

        btnCadVend = (Button) findViewById(R.id.btnCadVend);
        btnLoginVend = (Button) findViewById(R.id.btnLoginVend);

        btnLoginVend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btnLoginVendActivity();

            }
        });



        btnCadVend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btnCadVendActivity();

            }
        });
    }

    private void btnCadVendActivity() {

        startActivity(new Intent(AutenVend.this, CadVend.class));
    }

    private void btnLoginVendActivity() {

        startActivity(new Intent(AutenVend.this, PainelV.class));
    }
}