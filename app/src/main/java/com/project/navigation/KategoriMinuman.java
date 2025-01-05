package com.project.navigation;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class KategoriMinuman extends AppCompatActivity {

    private Button semuakat, makankat, minumkat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategori_minuman); // Pastikan layoutnya benar

        // Inisialisasi tombol
        semuakat = findViewById(R.id.semuakat);
        makankat = findViewById(R.id.makankat);
        minumkat = findViewById(R.id.minumkat);

        // Listener untuk tombol "Makanan"
        makankat.setOnClickListener(v -> {
            // Intent untuk berpindah ke KategoriMakanan
            Intent intent = new Intent(KategoriMinuman.this, KategoriMakanan.class);
            // Menambahkan parameter untuk kategori makanan
            intent.putExtra("kategori", "makanan");
            startActivity(intent);
        });

//        // Listener untuk tombol "Minuman"
//        minumkat.setOnClickListener(v -> {
//            // Intent untuk berpindah ke KategoriMakanan
//            Intent intent = new Intent(KategoriMakanan.this, KategoriMinuman.class);
//            // Menambahkan parameter untuk kategori minuman
//            intent.putExtra("kategori", "minuman");
//            startActivity(intent);
//        });

        // Listener untuk tombol "Semua Kategori"
        semuakat.setOnClickListener(v -> {
            // Intent untuk berpindah ke KategoriMakanan
            Intent intent = new Intent(KategoriMinuman.this, Menu.class);
            // Menambahkan parameter untuk kategori semua
            intent.putExtra("kategori", "semua");
            startActivity(intent);
        });
    }
}