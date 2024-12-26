package com.project.navigation;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {

    // Deklarasi komponen UI
    private EditText nama, noTelepon, username, password;
    private CheckBox syarat;
    private Button registerButton;

    // Konstanta untuk SharedPreferences
    private static final String PREFS_NAMA = "MyPrefs";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_NAMA = "nama";
    private static final String KEY_NO_TELEPON = "noTelepon";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Inisialisasi Views
        nama = findViewById(R.id.nama);
        noTelepon = findViewById(R.id.nope);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        syarat = findViewById(R.id.syarat);
        registerButton = findViewById(R.id.registerButton);

        // Listener untuk tombol register
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register(); // Panggil metode register
            }
        });
    }

    private void register() {
        // Ambil input dari form
        String namaUser = nama.getText().toString().trim();
        String noTeleponUser = noTelepon.getText().toString().trim();
        String usernameUser = username.getText().toString().trim();
        String passwordUser = password.getText().toString().trim();

        // Validasi form input
        if (namaUser.isEmpty() || noTeleponUser.isEmpty() || usernameUser.isEmpty() || passwordUser.isEmpty()) {
            Toast.makeText(this, "Semua kolom harus diisi", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!syarat.isChecked()) {
            Toast.makeText(this, "Anda harus menyetujui syarat dan ketentuan", Toast.LENGTH_SHORT).show();
            return;
        }

        // Simpan data pengguna ke SharedPreferences
        saveCredentials(namaUser, noTeleponUser, usernameUser, passwordUser);

        // Tampilkan pesan sukses
        Toast.makeText(this, "Registrasi Berhasil", Toast.LENGTH_SHORT).show();

        // Arahkan ke halaman login
        Intent intent = new Intent(Register.this, Login.class);
        startActivity(intent);
        finish();
    }

    private void saveCredentials(String nama, String noTelepon, String username, String password) {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAMA, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // Simpan data pengguna
        editor.putString(KEY_NAMA, nama);
        editor.putString(KEY_NO_TELEPON, noTelepon);
        editor.putString(KEY_USERNAME, username);
        editor.putString(KEY_PASSWORD, password);

        // Commit perubahan
        editor.apply();
    }
}
