package com.project.navigation;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Nota extends AppCompatActivity {

    private Button selesai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nota);

        selesai = findViewById(R.id.selesai);

        selesai.setOnClickListener(v -> {
            // Intent untuk berpindah ke KategoriMakanan
            Intent intent = new Intent(Nota.this, MainActivity.class);
            startActivity(intent);
        });

        }

    }