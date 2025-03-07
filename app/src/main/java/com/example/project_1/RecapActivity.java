package com.example.project_1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class RecapActivity extends AppCompatActivity {

    private TextView tvNom, tvEmail, tvPhone, tvAdresse, tvVille;
    private Button btnGoogle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recap);

        tvNom = findViewById(R.id.tvNom);
        tvEmail = findViewById(R.id.tvEmail);
        tvPhone = findViewById(R.id.tvPhone);
        tvAdresse = findViewById(R.id.tvAdresse);
        tvVille = findViewById(R.id.tvVille);
        btnGoogle = findViewById(R.id.btnGoogle);

        String nom = getIntent().getStringExtra("NOM");
        String email = getIntent().getStringExtra("EMAIL");
        String phone = getIntent().getStringExtra("PHONE");
        String adresse = getIntent().getStringExtra("ADRESSE");
        String ville = getIntent().getStringExtra("VILLE");

        tvNom.setText(nom);
        tvEmail.setText(email);
        tvPhone.setText(phone);
        tvAdresse.setText(adresse);
        tvVille.setText(ville);

        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
                startActivity(intent);
            }
        });
    }
}
