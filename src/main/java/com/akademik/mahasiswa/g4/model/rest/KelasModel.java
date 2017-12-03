package com.akademik.mahasiswa.g4.model.rest;

import com.akademik.mahasiswa.g4.model.db.MahasiswaDBModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class KelasModel {
    @JsonProperty("id")
    private int idKelas;
    @JsonProperty("nama")
    private String namaKelas;
    @JsonProperty("max_kapasitas")
    private int kapasitas;
    @JsonProperty("jadwalList")
    private List<JadwalKelasModel> waktu;


    @JsonIgnore
    private int mahasiswaSaatIni;
    @JsonIgnore
    private int idRiwayatPerkuliahan;
    @JsonIgnore
    private Date tanggalPengisian;

    //akan disave di db
    private String namaMK;
    private String kodeMK;
    private String kurikulum;
    private int sks;

    //dapet dari api penilaian
    private double nilaiAkhir;
    private String nilaiHuruf;

//    private List<DosenPengajarModel> pengajar;
    //for update
    @JsonIgnore
    private boolean selected;

    //for api to penilaian
    private List<MahasiswaDBModel> mahasiswa;
}
