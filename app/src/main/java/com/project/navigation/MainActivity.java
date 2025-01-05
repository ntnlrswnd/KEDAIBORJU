package com.project.navigation;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private final homeFragment homeFragment = new homeFragment();
    private final PemberitahuanFragment PemberitahuanFragment = new PemberitahuanFragment();
    private final settingFragment settingFragment = new settingFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi BottomNavigationView
        BottomNavigationView bottomNavigationView = findViewById(R.id.btm_nav);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.home) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.flFragment, homeFragment) // Ganti dengan homeFragment
                            .addToBackStack(null) // Menambahkan ke backstack
                            .commit();
                    return true;

                } else if (id == R.id.notif) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.flFragment, PemberitahuanFragment) // Ganti dengan menuFragment
                            .addToBackStack(null) // Menambahkan ke backstack
                            .commit();
                    return true;

                } else if (id == R.id.setting) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.flFragment, settingFragment) // Ganti dengan settingFragment
                            .addToBackStack(null) // Menambahkan ke backstack
                            .commit();
                    return true;
                }

                return false;
            }
        });

        bottomNavigationView.setSelectedItemId(R.id.home); // Menetapkan item default sebagai home
    }
}
