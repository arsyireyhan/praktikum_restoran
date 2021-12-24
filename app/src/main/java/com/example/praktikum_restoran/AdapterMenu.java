package com.example.praktikum_restoran;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class AdapterMenu extends RecyclerView.Adapter<AdapterMenu.MenuViewHolder> {
    private Context mContext;
    private Cursor mCursor;
    List<ModelMenu> mMenu;
    DBHelper db;
    Fragment_Menu fragment_menu;

    public AdapterMenu(Context context, List<ModelMenu> mMenu, Fragment_Menu fragment_menu) {
        this.mContext = context;
        this.mMenu = mMenu;
        this.fragment_menu = fragment_menu;
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder{
        public TextView Id_Menu;
        public TextView Menu;
        public TextView Kategori;
        public TextView Harga;

        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);
            Id_Menu = itemView.findViewById(R.id.id_Menu);
            Menu = itemView.findViewById(R.id.nama_menu);
            Harga = itemView.findViewById(R.id.HargaMakanan);
        }
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.item_menu, parent, false);
        MenuViewHolder mHolder = new MenuViewHolder(view);
        return mHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
//        if(!mCursor.move(position)){
//            return;
//        }
//        int id_menu = mCursor.getInt(mCursor.getColumnIndex());
//        String menu = mCursor.getString(mCursor.getColumnIndex(DBHelper.KOLOM_MENU));
//        String kategori = mCursor.getString(mCursor.getColumnIndex(DBHelper.KOLOM_KATEGORI));
//
//        holder.Id_Menu.setText(String.valueOf(id_menu));
//        holder.Menu.setText(menu);
//        holder.Kategori.setText(kategori);

        holder.Id_Menu.setText(mMenu.get(position).getId_menu());
        holder.Menu.setText(mMenu.get(position).getMenu());
        holder.Harga.setText(mMenu.get(position).getHarga());
    }

    @Override
    public int getItemCount() {
        return mMenu.size();
    }




//
//    public void swapCursor(Cursor newcursor){
//        if (mCursor != null){
//            mCursor.close();
//        }
//        mCursor = newcursor;
//        if (newcursor != null){
//            notifyDataSetChanged();
//        }
//    }

}
