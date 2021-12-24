package com.example.praktikum_restoran;

public class ModelMenu {
    private int id_menu;
    private String menu;
    private int harga;
    private String kategori;

    //constructor
    public ModelMenu(int id_menu, String menu, int harga) {
        this.id_menu = id_menu;
        this.menu = menu;
        this.harga = harga;
//        this.kategori = kategori;
    }

    //toString

    @Override
    public String toString() {
        return "ModelMenu{" +
                "id_menu=" + id_menu +
                ", menu='" + menu + '\'' +
                ", harga='" + harga + '\'' +
                ", kategori='" + kategori + '\'' +
                '}';
    }


    //getter & setter

    public int getId_menu() {
        return id_menu;
    }

    public void setId_menu(int id_menu) {
        this.id_menu = id_menu;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getKategori(){ return kategori;}

    public void  setKategori(String kategori) {this.kategori = kategori;}

}
