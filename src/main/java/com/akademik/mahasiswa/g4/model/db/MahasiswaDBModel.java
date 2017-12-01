package com.akademik.mahasiswa.g4.model.db;

public class MahasiswaDBModel {
    private String npm;
    private String nama;
    private String username;
    private int idUniv;
    private int idProdi;
    private String angkata;

    public MahasiswaDBModel(String npm, String nama, String username, int idUniv, int idProdi, String angkata) {
        this.npm = npm;
        this.nama = nama;
        this.username = username;
        this.idUniv = idUniv;
        this.idProdi = idProdi;
        this.angkata = angkata;
    }

    public MahasiswaDBModel() {
    }

    public String getNpm() {
        return npm;
    }

    public void setNpm(String npm) {
        this.npm = npm;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getIdUniv() {
        return idUniv;
    }

    public void setIdUniv(int idUniv) {
        this.idUniv = idUniv;
    }

    public int getIdProdi() {
        return idProdi;
    }

    public void setIdProdi(int idProdi) {
        this.idProdi = idProdi;
    }

    public String getAngkata() {
        return angkata;
    }

    public void setAngkata(String angkata) {
        this.angkata = angkata;
    }
}
