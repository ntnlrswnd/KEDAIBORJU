package com.project.navigation;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class Pesanan extends AppCompatActivity {

    private EditText editTextHarga;
    private Button pesan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesanan); // Pastikan layout yang benar digunakan

        pesan = findViewById(R.id.btnpesan);

        pesan.setOnClickListener(v -> {
            // Intent untuk berpindah ke KategoriMakanan
            Intent intent = new Intent(Pesanan.this, Nota.class);
            // Menambahkan parameter untuk kategori minuman
            intent.putExtra("kategori", "minuman");
            startActivity(intent);
        });

    }
}
