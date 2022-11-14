package org.iesch.a13_shared_preferences_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    Button btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnSalir = findViewById(R.id.btnLogout);
        btnSalir.setOnClickListener(view -> {
            logout();
        });
    }

    private void logout() {
        SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor obj_editor = preferences.edit();

        obj_editor.putString("email", "");
        obj_editor.putString("pass", "");
        obj_editor.commit();

        Intent i = new Intent(HomeActivity.this, MainActivity.class);
        startActivity(i);
    }
}