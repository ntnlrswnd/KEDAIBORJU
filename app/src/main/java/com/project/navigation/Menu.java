package com.project.navigation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Menu extends AppCompatActivity {

    private Button semuakat, makankat, minumkat;
    private CardView dtlmakan, dtlminum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // Initialize buttons and CardViews
        semuakat = findViewById(R.id.semuakat);
        makankat = findViewById(R.id.makankat);
        minumkat = findViewById(R.id.minumkat);
        dtlmakan = findViewById(R.id.menu);
        dtlminum = findViewById(R.id.dtlminum);

        // Listener for "Makanan" button
        makankat.setOnClickListener(v -> {
            // Intent to navigate to KategoriMakanan Activity
            Intent intent = new Intent(Menu.this, KategoriMakanan.class);
            intent.putExtra("kategori", "makanan");  // Passing category parameter for "makanan"
            startActivity(intent);
        });

        // Listener for "Minuman" button
        minumkat.setOnClickListener(v -> {
            // Intent to navigate to KategoriMinuman Activity
            Intent intent = new Intent(Menu.this, KategoriMinuman.class);
            intent.putExtra("kategori", "minuman");  // Passing category parameter for "minuman"
            startActivity(intent);
        });

        // Listener for CardView leading to DetailMenuMakanan
        dtlmakan.setOnClickListener(v -> {
            // Intent to navigate to DetailMenuMakanan Activity
            Intent intent = new Intent(Menu.this, DetailMenuMakanan.class);
            startActivity(intent);
        });

        // Listener for CardView leading to DetailMenuMinuman
        dtlminum.setOnClickListener(v -> {
            // Intent to navigate to DetailMenuMinuman Activity
            Intent intent = new Intent(Menu.this, DetailMenuMinuman.class);
            startActivity(intent);
        });
    }
}
