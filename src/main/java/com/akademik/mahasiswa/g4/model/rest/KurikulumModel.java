package com.akademik.mahasiswa.g4.model.rest;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class KurikulumModel {

    @JsonProperty("kode_kurikulum")
    private String kode;
    @JsonProperty("jumlah_sks_wajib")
    private int jumlahSKSWajib;
    @JsonProperty("jumlah_sks_pilihan")
    private int jumlahSKSPilihan;
    @JsonProperty("batas_sks_lulus")
    private int batasSKSLulus;
    @JsonProperty("matkulList")
    private List<MatakuliahModel> matakul;

}
