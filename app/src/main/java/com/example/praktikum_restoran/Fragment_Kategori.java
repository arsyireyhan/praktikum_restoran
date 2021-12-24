package com.example.praktikum_restoran;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class Fragment_Kategori extends Fragment {
    private DBHelper dbHelper;
    private List<ModelKategori> listKategori = new ArrayList<>();
    public AdapterKategori adapterKategori;
    private FloatingActionButton floatingBtnKategori;
    private RecyclerView rvKategori;
    private LinearLayoutManager layoutManager;
    View view;

    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        view = inflater.inflate(R.layout.fragment_kategori, container, false);
        rvKategori = (RecyclerView) view.findViewById(R.id.listKategori);
        adapterKategori = new AdapterKategori(getContext(), listKategori, this);
        rvKategori.setAdapter(adapterKategori);
        rvKategori.setLayoutManager(new LinearLayoutManager(getActivity()));
        floatingBtnKategori = view.findViewById(R.id.floatBtnKategori);
        floatingBtnKategori.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), tambah_kategori.class);
                startActivity(intent);
            }
        });



//        dbHelper = new DBHelper((getContext()));
//        kategori = new ArrayList<>();
//        getDataKategori();

//        adapterKategori = new AdapterKategori(view.getContext(), );
//        layoutManager = new LinearLayoutManager(view.getContext());
//        layoutManager.setReverseLayout(true);
//        layoutManager.setStackFromEnd(true);
//
//        rvKategori = view.findViewById(R.id.listMenu);
//        rvKategori.setLayoutManager(layoutManager);
//        rvKategori.setAdapter(adapterKategori);

        return view;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        listKategori = new ArrayList<>();
    }

//    private void getDataKategori(){
//        Cursor cursor = dbHelper.ReadDataMenu();
//        if (cursor.getCount() == 0){
//            Toast.makeText(getContext(), "data tidak tersedia", Toast.LENGTH_SHORT).show();
//        } else {
//            while (cursor.moveToNext()){
//                kategori.add(cursor.getString(0));
//            }
//        }
//    }

    @Override
    public void onResume(){
        super.onResume();
        adapterKategori.notifyDataSetChanged();
    }
}
