package com.project.navigation;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class KategoriMakanan extends AppCompatActivity {

    private Button semuakat, makankat, minumkat;
    private CardView lihatDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategori_makanan); // Pastikan layoutnya benar

        // Inisialisasi tombol
        semuakat = findViewById(R.id.semuakat);
        makankat = findViewById(R.id.makankat);
        minumkat = findViewById(R.id.minumkat);
        lihatDetail = findViewById(R.id.menu);

//        // Listener untuk tombol "Makanan"
//        makankat.setOnClickListener(v -> {
//            // Intent untuk berpindah ke KategoriMakanan
//            Intent intent = new Intent(KategoriMakanan.this, KategoriMakanan.class);
//            // Menambahkan parameter untuk kategori makanan
//            intent.putExtra("kategori", "makanan");
//            startActivity(intent);
//        });

        // Listener untuk tombol "Minuman"
        minumkat.setOnClickListener(v -> {
            // Intent untuk berpindah ke KategoriMakanan
            Intent intent = new Intent(KategoriMakanan.this, KategoriMinuman.class);
            // Menambahkan parameter untuk kategori minuman
            intent.putExtra("kategori", "minuman");
            startActivity(intent);
        });

        // Listener untuk tombol "Semua Kategori"
        semuakat.setOnClickListener(v -> {
            // Intent untuk berpindah ke KategoriMakanan
            Intent intent = new Intent(KategoriMakanan.this, Menu.class);
            // Menambahkan parameter untuk kategori semua
            intent.putExtra("kategori", "semua");
            startActivity(intent);
        });

        lihatDetail.setOnClickListener(v -> {
            // Intent untuk berpindah ke DetailMenuMakanan Activity
            Intent intent = new Intent(KategoriMakanan.this, DetailMenuMakanan.class);
            startActivity(intent);
        });
    }
}