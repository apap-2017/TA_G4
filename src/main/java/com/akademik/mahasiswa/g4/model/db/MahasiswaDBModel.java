package com.akademik.mahasiswa.g4.model.db;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MahasiswaDBModel {
    private String npm;
    private String nama;
    private String username;
    private String namaUniv;
    private String namaFakultas;
    private String namaProdi;
    private int idUniv;
    private int idFakultas;
    private int idProdi;
    private String angkatan;

    public void setNpm(String npm) {
        this.npm = npm;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setIdUniv(int idUniv) {
        this.idUniv = idUniv;
    }

    public void setIdFakultas(int idFakultas) {
        this.idFakultas = idFakultas;
    }

    public void setIdProdi(int idProdi) {
        this.idProdi = idProdi;
    }

    public void setAngkatan(String angkatan) {
        this.angkatan = angkatan;
    }

    public String getNpm() {

        return npm;
    }

    public String getNama() {
        return nama;
    }

    public String getUsername() {
        return username;
    }

    public int getIdUniv() {
        return idUniv;
    }

    public int getIdFakultas() {
        return idFakultas;
    }

    public int getIdProdi() {
        return idProdi;
    }

    public String getAngkatan() {
        return angkatan;
    }
}
