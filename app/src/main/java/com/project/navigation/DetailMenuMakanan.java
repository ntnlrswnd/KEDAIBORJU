package com.project.navigation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailMenuMakanan extends AppCompatActivity {

    private Button pesan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_menu_makanan);
        pesan = findViewById(R.id.pesan);

        pesan.setOnClickListener(v -> {
            // Intent untuk berpindah ke Pesanan
            Intent intent = new Intent(DetailMenuMakanan.this, Pesanan.class);
            // Menambahkan parameter untuk kategori makanan
            intent.putExtra("kategori", "makanan");
            startActivity(intent);
        });
    }
}
