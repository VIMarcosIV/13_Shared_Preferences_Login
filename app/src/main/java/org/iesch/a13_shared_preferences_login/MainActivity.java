package org.iesch.a13_shared_preferences_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    Button btnLogin;
    EditText editTextEmail;
    EditText editTextPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btnEntrar);
        editTextEmail = findViewById(R.id.editTextEmailAddress);
        editTextPassword = findViewById(R.id.editTextPassword);

        // 1.- Al iniciar la Aplicacion debe mostras lo que tiene GUARDADO en el archivo SharedPreferences
        // Obtengo los valores que se han creado previamente

        SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);

        if (preferences.getString("email", "") != "") {
            Intent i = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(i);
        }


        // 2.- Escribiamos los referencias que hemos obtenido en el valor que buscamos
        // El par de comillas vacío es el valor inicial EN CASO DE QUE NO HAYA NINGUN VALOR
        editTextEmail.setText(preferences.getString("email", ""));
        editTextPassword.setText(preferences.getString("pass", ""));

        btnLogin.setOnClickListener(view -> {
            guardar();
            Toast.makeText(this, "Se ha guardado correctamente", Toast.LENGTH_SHORT).show();
        });

    }

    private void guardar() {
        // En este metodo he de crear el objeto nuevamente
        SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);

        // Editor es la clase que me sirve para modificar este archivo
        SharedPreferences.Editor obj_editor = preferences.edit();

        obj_editor.putString("email", editTextEmail.getText().toString());
        obj_editor.putString("pass", editTextPassword.getText().toString());
        // Comit confirma que lo que acabamos de recuperar arriba lo queremos GUARDAR
        // Sin comit no guarda nada en SharedPreferences
        obj_editor.commit();
        finish();


    }
}