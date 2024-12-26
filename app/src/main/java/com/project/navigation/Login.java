package com.project.navigation;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.project.navigation.MainActivity;

public class Login extends AppCompatActivity {

    private EditText username, password;
    private Button loginButton; // Untuk tombol "Masuk"
    private TextView daftarText; // Untuk teks "Daftar"

    private static final String PREFS_NAMA = "MyPrefs";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Inisialisasi Views
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton); // Tombol "Masuk"
        daftarText = findViewById(R.id.daftar); // Teks "Daftar"

        // Set Listener untuk tombol "Masuk"
        loginButton.setOnClickListener(view -> login());

        // Set Listener untuk teks "Daftar"
        daftarText.setOnClickListener(view -> openRegister());
    }

    private void login() {
        // Ambil inputan user
        String inputUsername = username.getText().toString().trim();
        String inputPassword = password.getText().toString().trim();

        // Validasi input kosong
        if (inputUsername.isEmpty() || inputPassword.isEmpty()) {
            Toast.makeText(this, "Nama pengguna dan kata sandi tidak boleh kosong", Toast.LENGTH_SHORT).show();
            return;
        }

        // Ambil data dari SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAMA, MODE_PRIVATE);
        String savedUsername = sharedPreferences.getString(KEY_USERNAME, null);
        String savedPassword = sharedPreferences.getString(KEY_PASSWORD, null);

        // Cek login
        if (inputUsername.equals(savedUsername) && inputPassword.equals(savedPassword)) {
            Toast.makeText(this, "Login Berhasil!", Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(Login.this, MainActivity.class);
            Intent intent = new Intent(Login.this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Nama pengguna atau kata sandi salah", Toast.LENGTH_SHORT).show();
        }
    }

    private void openRegister() {
        // Navigasi ke halaman registrasi
        Intent intent = new Intent(Login.this, Register.class);
        startActivity(intent);
    }
}
