package com.example.project_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etNom, etEmail, etPhone, etAdresse;
    private Spinner spinnerVille;
    private Button btnEnvoyer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNom = findViewById(R.id.etNom);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        etAdresse = findViewById(R.id.etAdresse);
        spinnerVille = findViewById(R.id.spinnerVille);
        btnEnvoyer = findViewById(R.id.btnEnvoyer);

        String[] villes = {"Agadir", "Casablanca", "Marrakech", "Rabat", "Tanger"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, villes);
        spinnerVille.setAdapter(adapter);

        btnEnvoyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom = etNom.getText().toString();
                String email = etEmail.getText().toString();
                String phone = etPhone.getText().toString();
                String adresse = etAdresse.getText().toString();
                String ville = spinnerVille.getSelectedItem().toString();

                Intent intent = new Intent(MainActivity.this, com.example.project_1.RecapActivity.class);
                intent.putExtra("NOM", nom);
                intent.putExtra("EMAIL", email);
                intent.putExtra("PHONE", phone);
                intent.putExtra("ADRESSE", adresse);
                intent.putExtra("VILLE", ville);
                startActivity(intent);
            }
        });
    }
}
