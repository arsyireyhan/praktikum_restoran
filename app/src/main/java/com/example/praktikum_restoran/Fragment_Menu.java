package com.example.praktikum_restoran;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class Fragment_Menu extends Fragment {
    private FloatingActionButton floatBtnTambah;
    private DBHelper dbHelper;
    private List<ModelMenu> listMenu;
    private View dialogView;
    private AlertDialog.Builder dialog;
    private LayoutInflater inflater;

    private RecyclerView rvMenu;
    private LinearLayoutManager layoutManager;
    public AdapterMenu adapterMenu;


    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View root = inflater.inflate(R.layout.fragment_menu, container, false);
        rvMenu = (RecyclerView) root.findViewById(R.id.listMenu);
        adapterMenu = new AdapterMenu(getContext(), listMenu, this);
        rvMenu.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvMenu.setAdapter(adapterMenu);
        dbHelper = new DBHelper(getContext());
        floatBtnTambah = root.findViewById(R.id.floatBtnTambahMenu);
        floatBtnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), tambah_menu.class);
                startActivity(intent);
            }
        });


//        dbHelper = new DBHelper((getContext()));
//        listMenu = new ArrayList<>();
//        getDataMenu();

//        layoutManager = new LinearLayoutManager(view.getContext());
//        layoutManager.setReverseLayout(true);
//        layoutManager.setStackFromEnd(true);

//        rvMenu = view.findViewById(R.id.listMenu);
//        rvMenu.setLayoutManager(layoutManager);
//        rvMenu.setAdapter(adapterMenu);

        return root;
    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        listMenu = new ArrayList<>();
    }


//    private void getDataMenu(){
//        Cursor cursor = dbHelper.ReadDataMenu();
//        if (cursor.getCount() == 0){
//            Toast.makeText(getContext(), "data tidak tersedia", Toast.LENGTH_SHORT).show();
//        } else {
//            while (cursor.moveToNext()){
//                id_menu.add(cursor.getString(0));
//                menu.add(cursor.getString(1));
//                harga.add(cursor.getString(2));
//            }
//        }
//    }

    @Override
    public void onResume(){
        super.onResume();
        adapterMenu.notifyDataSetChanged();
    }

//        floatBtnTambah.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                OpenActivity2();
//                Toast.makeText(MainActivity.this, "ini menu penginputan data", Toast.LENGTH_SHORT).show();
//            }
//        });
}
