package com.example.praktikum_restoran;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.praktikum_restoran.ModelMenu;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    private Context context;
    public static final String TB_MENU = "TB_MENU";
    public static final String KOLOM_ID_MENU = "ID_MENU";
    public static final String KOLOM_MENU = "MENU";
    public static final String KOLOM_HARGA = "HARGA";
    public static final String TB_KATEGORI = "TB_KATEGORI";
    public static final String KOLOM_ID_KATEGORI = "ID_KATEGORI";
    public static final String KOLOM_KATEGORI = "KATEGORI";

    public DBHelper(@Nullable Context context) {
        super(context, "DB_RESTORAN", null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableMenu = "CREATE TABLE " + TB_MENU + " " +
                "(" + KOLOM_ID_MENU + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                " " + KOLOM_MENU + " TEXT," +
                " " + KOLOM_HARGA + "INTEGER)";

        String createTableKategori = "CREATE TABLE " + TB_KATEGORI + " " +
                "(" + KOLOM_ID_KATEGORI + " INTEGER PRIMARY KEY," +
                " " + KOLOM_KATEGORI + " TEXT)";

        db.execSQL(createTableMenu);
        db.execSQL(createTableKategori);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TB_MENU);
        db.execSQL("DROP TABLE IF EXISTS " + TB_KATEGORI);
        onCreate(db);
    }

    //CREATE & INSERT DATA
    public boolean tambahMenu(ModelMenu modelMenu) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(KOLOM_MENU, modelMenu.getMenu());
        cv.put(KOLOM_HARGA, modelMenu.getHarga());

        long result = db.insert(TB_MENU, null, cv);
        if (result == -1) {
            Toast.makeText(context, "gagal menginputkan data", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            Toast.makeText(context, "data berhasil diinputkan!", Toast.LENGTH_SHORT).show();
            return true;
        }
    }

    public boolean tambahKategori(ModelKategori modelKategori) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(KOLOM_KATEGORI, modelKategori.getKategori());

        long result = db.insert(TB_KATEGORI, null, cv);
        if (result == -1) {
            Toast.makeText(context, "gagal menginputkan data", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            Toast.makeText(context, "data berhasil diinputkan!", Toast.LENGTH_SHORT).show();
            return true;
        }
    }

    //READ DATA
    Cursor ReadDataMenu() {
        String showTableMenu = "SELECT * FROM " + TB_KATEGORI;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;

        if (db != null) {
            cursor = db.rawQuery(showTableMenu, null);
        }
        return cursor;
    }

    Cursor ReadDataKategori() {
        String showTableKategori = "SELECT * FROM " + TB_KATEGORI;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;

        if (db != null) {
            cursor = db.rawQuery(showTableKategori, null);
        }
        return cursor;
    }

    Cursor readByIdMenu(String id_menu) {
        String showMenu = "SELECT * FROM " + TB_MENU + " WHERE " + KOLOM_ID_MENU + "=" + id_menu;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(showMenu, null);
        }
        return cursor;
    }

    Cursor readByIdKategori(String id_kategori) {
        String showKategori = "SELECT * FROM " + TB_KATEGORI + " WHERE " + KOLOM_ID_KATEGORI + "=" + id_kategori;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(showKategori, null);
        }
        return cursor;
    }

    Cursor readLastRowIdMenu() {
        String lastRowMenu = "SELECT * FROM " + TB_MENU + " ORDER BY " + KOLOM_ID_MENU + " DESC LIMIT 1";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(lastRowMenu, null);
        }
        return cursor;
    }

    Cursor readLastRowIdKategori() {
        String lastRowKategori = "SELECT * FROM " + TB_KATEGORI + " ORDER BY " + KOLOM_ID_KATEGORI + " DESC LIMIT 1";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(lastRowKategori, null);
        }
        return cursor;
    }

    // UPDATE DATA
    void updateDataMenu(String id_menu, String menu, String harga) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(KOLOM_ID_MENU, id_menu);
        cv.put(KOLOM_MENU, menu);
        cv.put(KOLOM_HARGA, harga);

        long result = db.update(TB_MENU, cv, "_id=?", new String[]{id_menu});

        if (result == -1) {
            Toast.makeText(context, "Gagal memperbarui data!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Berhasil memperbarui data!", Toast.LENGTH_SHORT).show();
        }
    }

    void updateDataKategori(String id_kategori, String kategori) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(KOLOM_ID_KATEGORI, id_kategori);
        cv.put(KOLOM_KATEGORI, kategori);

        long result = db.update(TB_MENU, cv, "_id=?", new String[]{id_kategori});

        if (result == -1) {
            Toast.makeText(context, "Gagal memperbarui data!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Berhasil memperbarui data!", Toast.LENGTH_SHORT).show();
        }
    }

    //DELETE DATA
    public void deleteDataMenu(String id_menu) {
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TB_MENU, "_id=?", new String[]{id_menu});
        if (result == -1) {
            Toast.makeText(context, "Gagal menghapus data!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Berhasil menghapus data!", Toast.LENGTH_SHORT).show();
        }
    }

    public void deleteDataKategori(String id_kategori) {
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TB_KATEGORI, "_id=?", new String[]{id_kategori});
        if (result == -1) {
            Toast.makeText(context, "Gagal menghapus data!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Berhasil menghapus data!", Toast.LENGTH_SHORT).show();
        }
    }
}










//    //add item to DB
//    public boolean addMenu(ModelMenu modelMenu){
//        SQLiteDatabase db = getWritableDatabase();
//        ContentValues cv = new ContentValues();
//
//        cv.put(KOLOM_MENU, modelMenu.getMenu());
//        cv.put(KOLOM_HARGA, modelMenu.getHarga());
//
//        long insert = db.insert(TB_MENU, null, cv);
//        if (insert == -1){
//            return false;
//        }else {
//            return true;
//        }
//    }
//
//    public boolean addKategori(ModelKategori modelKategori){
//        SQLiteDatabase db = getWritableDatabase();
//        ContentValues cv = new ContentValues();
//
//        cv.put(KOLOM_MENU, modelKategori.getKategori());
//
//        long insert = db.insert(TB_MENU, null, cv);
//        if (insert == -1){
//            return false;
//        }else {
//            return true;
//        }
//    }
//
//
//    public List<ModelMenu> getMenu(){
//          List<ModelMenu> returnList = new ArrayList<>();
//          //query tampilkan data (select * from ...)
//          String queryTampilkan = "SELECT * FROM " + TB_MENU;
//          //ambil data dari DB
//          SQLiteDatabase db = getReadableDatabase();
//        Cursor cur = db.rawQuery(queryTampilkan,null);
//        //cek apakah hasil didapatkan dari DB
//
//        if (cur.moveToNext()){
//            do {
//                int ID_Menu = cur.getInt(0);
//                String Menu = cur.getString(1);
//                int Harga = cur.getInt(2);
//
//                ModelMenu MenuBaru = new ModelMenu(ID_Menu, Menu, Harga);
//                returnList.add(MenuBaru);
//
//            }while (cur.moveToNext());
//
//        }else {
//            //jika gagal, tidak ditambahkan kedalam list menu
//
//
//        }
//        //tutup cursor dan db setelah selesai proses
//        cur.close();
//        db.close();
//        return returnList;
//    }
