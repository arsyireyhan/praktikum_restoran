package com.example.praktikum_restoran;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class tambah_menu extends AppCompatActivity {

    Spinner namaKategori;
    RadioButton radioButton;
    Button buttonAdd;
    EditText namaMenu, hargaMakanan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tambah_menu);

        namaKategori = findViewById(R.id.spinKategori);
        buttonAdd = findViewById(R.id.AddButton);
        namaMenu = findViewById(R.id.namamenu);
        hargaMakanan = findViewById(R.id.HargaMakanan);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              ModelMenu modelMenu;
                try {
                    modelMenu = new ModelMenu (-1, namaMenu.getText().toString(), Integer.parseInt(hargaMakanan.getText().toString()));
                    Toast.makeText(tambah_menu.this, modelMenu.toString(), Toast.LENGTH_SHORT).show();
                }catch(Exception e){
                    Toast.makeText(tambah_menu.this, "ERROR, tidak dapat menginputkan data!", Toast.LENGTH_SHORT).show();
                    modelMenu = new ModelMenu(-1, "error", 0);
                }

                DBHelper dbHelper = new DBHelper(tambah_menu.this);
                //insert data
                boolean tambahMenu = dbHelper.tambahMenu(modelMenu);
                Toast.makeText(tambah_menu.this, "data berhasil dimasukkan " + tambahMenu, Toast.LENGTH_SHORT).show();

                toMainActivity();
            }
        });

    }

    public void kategoriSpinner(View view){

    }

    public void toMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
