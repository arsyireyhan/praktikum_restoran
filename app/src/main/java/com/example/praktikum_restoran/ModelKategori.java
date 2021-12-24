package com.example.praktikum_restoran;

public class ModelKategori {
    private int id_kategori;
    private String kategori;

    //constructor
    public ModelKategori(int id_kategori, String kategori) {
        this.id_kategori = id_kategori;
        this.kategori = kategori;
    }

    //toString
    @Override
    public String toString() {
        return "ModelKategori{" +
                "id_kategori=" + id_kategori +
                ", kategori='" + kategori + '\'' +
                '}';
    }

    //getter & setter

    public int getId_kategori() {
        return id_kategori;
    }

    public void setId_kategori(int id_kategori) {
        this.id_kategori = id_kategori;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }
}
