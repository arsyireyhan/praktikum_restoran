package com.example.praktikum_restoran;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class tambah_kategori extends AppCompatActivity {

    EditText nama_kategori_tambah;
    Button btn_tambah_kategori;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tambah_kategori);

        nama_kategori_tambah = findViewById(R.id.nama_kategori_tambah);
        btn_tambah_kategori = findViewById(R.id.btn_tambah_kategori);

        btn_tambah_kategori.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ModelKategori modelKategori;
                try {
                    modelKategori = new ModelKategori (-1, nama_kategori_tambah.getText().toString());
                    Toast.makeText(tambah_kategori.this, modelKategori.toString(), Toast.LENGTH_SHORT).show();
                }catch(Exception e){
                    Toast.makeText(tambah_kategori.this, "ERROR, tidak dapat menginputkan data!", Toast.LENGTH_SHORT).show();
                    modelKategori = new ModelKategori(-1, "error");
                }

                DBHelper dbHelper = new DBHelper(tambah_kategori.this);
                //insert data
                boolean addKategori = dbHelper.tambahKategori(modelKategori);
                Toast.makeText(tambah_kategori.this, "data berhasil dimasukkan " + addKategori, Toast.LENGTH_SHORT).show();

                toMainActivity();
            }
        });

    }

    public void toMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}