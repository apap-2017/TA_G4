package com.akademik.mahasiswa.g4.model.rest;

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
    private int idKelas;
    private int idRiwayatPerkuliahan;
    private Date tanggalPengisian;
    private String namaKelas;
    private int kapasitas;
    private int mahasiswaSaatIni;
    private String kodeMK;
    private List<JadwalKelasModel> waktu;
    private String kurikulum;
    private int sks;
    private double nilaiAkhir;
    private String nilaiHuruf;
    private List<DosenPengajarModel> pengajar;
}
