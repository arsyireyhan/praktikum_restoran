package com.example.praktikum_restoran;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        //ambil data dari DB ke layout mainActivity
//        listMenu = findViewById(R.id.listMenu);

        bottomNavigationView = findViewById(R.id.nav_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_menu, R.id.navigation_kategori
        ).build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);


//        bottomNavigationView.setOnItemSelectedListener(navListener);
//        getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container, new Fragment_Menu()).commit();



    }

//    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
//            new BottomNavigationView.OnNavigationItemSelectedListener() {
//                @Override
//                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                    Fragment selectedFragment = null;
//
//                    switch (item.getItemId()) {
//                        case R.id.navigation_menu:
//                            selectedFragment = new Fragment_Menu();
//                            break;
//                        case R.id.navigation_kategori:
//                            selectedFragment = new Fragment_Kategori();
//                            break;
//                    }
//
//                    return true;
//                }
//            };
}


//        floatBtnTambahMenu = findViewById(R.id.floatBtnTambahMenu);
//            floatBtnTambahMenu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                OpenActivityTambahMenu();
//                Toast.makeText(MainActivity.this, "ini menu penginputan data", Toast.LENGTH_SHORT).show();
//            }
//        });

//        floatBtnTambahMenu = findViewById(R.id.floatBtnKategori);
//        floatBtnTambahKategori.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                OpenActivityTambahKategori();
//                Toast.makeText(MainActivity.this, "ini menu penginputan kategori", Toast.LENGTH_SHORT).show();
//            }
//        });

//    public void OpenActivityTambahMenu(){
//        Intent intentMenu = new Intent(this, tambah_menu.class);
//        startActivity(intentMenu);
//    }

//    public void OpenActivityTambahKategori(){
//        Intent intentKategori = new Intent(this, tambah_kategori.class);
//        startActivity(intentKategori);
//    }



//
//        //membuatkan button tambah menu
//        floatBtnTambah = findViewById(R.id.floatBtnTambah);
//        floatBtnTambah.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                OpenActivity2();
//                Toast.makeText(MainActivity.this, "ini menu penginputan data", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        //menampilkan list menu makanan
//        listMenu = findViewById(R.id.listMenu);
//
//    }
//
//    public void OpenActivity2(){
//        Intent intent = new Intent(this, tambah_menu.class);
//        startActivity(intent);
//    }
