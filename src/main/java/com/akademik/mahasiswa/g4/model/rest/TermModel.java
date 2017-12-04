package com.akademik.mahasiswa.g4.model.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

//import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TermModel {

//    private int id;
    @JsonProperty("tahun_ajaran")
    private String tahunAjar;
    @JsonProperty("nomor")
    private int nomor;
//    private Date wantuMulai;
//    private Date waktuAkhir;
//    private Date waktuStartIsiIrs;
//    private Date waktuAkhirIsiIrs;
//    private int idUniv;
//    private int idFakultas;
//    private int idProdi;


    public String getTahunAjar() {
        return tahunAjar;
    }

    public void setTahunAjar(String tahunAjar) {
        this.tahunAjar = tahunAjar;
    }

    public int getNomor() {
        return nomor;
    }

    public void setNomor(int nomor) {
        this.nomor = nomor;
    }
}
