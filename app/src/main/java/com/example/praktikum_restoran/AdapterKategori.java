package com.example.praktikum_restoran;

import android.content.Context;
import android.content.DialogInterface;
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

public class AdapterKategori extends RecyclerView.Adapter<AdapterKategori.KategoriViewHolder> {
    Context kContext;
    Cursor mCursor;
    List<ModelKategori> mKategori;
    DBHelper db;
    RecyclerView rvKategori;
    Fragment_Kategori fragment_kategori;
    final View.OnClickListener onClickListener = new MyOnClickListener();

    public AdapterKategori(Context context, List<ModelKategori> mKategori, Fragment_Kategori fragment_kategori) {
        this.kContext = context;
        this.mKategori = mKategori;
        this.fragment_kategori = fragment_kategori;
        this.rvKategori = rvKategori; 
    }

    public class KategoriViewHolder extends RecyclerView.ViewHolder{
      TextView Kategori;

        public KategoriViewHolder(@NonNull View itemView) {
            super(itemView);
            Kategori = (TextView) itemView.findViewById(R.id.nama_kategori);
        }
    }

    @NonNull
    @Override
    public KategoriViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(kContext);
        View view = inflater.inflate(R.layout.item_kategori,parent,false);
        view.setOnClickListener(onClickListener);
        KategoriViewHolder kHolder = new KategoriViewHolder(view);
        return kHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull KategoriViewHolder holder, int position) {
//        if(!mCursor.move(position)){
//            return;
//        }
//
//        String nama_kategori = mCursor.getString(mCursor.getColumnIndex(DBHelper.KOLOM_KATEGORI));
        ModelKategori modelKategori = mKategori.get(position);
        holder.Kategori.setText(modelKategori.getKategori());
    }

    @Override
    public int getItemCount() {
        return mKategori.size();
    }

    private class MyOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
             int itemPosition = rvKategori.getChildLayoutPosition(view);
             String kategori = mKategori.get(itemPosition).getKategori();
        }
    }


//    public void swapCursor(Cursor newcursor){
//        if (mCursor != null){
//            mCursor.close();
//        }
//
//        mCursor = newcursor;
//        if (newcursor != null){
//            notifyDataSetChanged();
//        }
//    }

}
