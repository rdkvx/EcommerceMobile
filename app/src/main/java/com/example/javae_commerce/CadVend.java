package com.example.javae_commerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CadVend extends AppCompatActivity {

    private Button btnCadVend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_vend);

        btnCadVend = (Button) findViewById(R.id.btnCadVend);


        btnCadVend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btnCadVendActivity();

            }
        });
    }

    private void btnCadVendActivity() {

        startActivity(new Intent( CadVend.this, AutenVend.class));
    }
}