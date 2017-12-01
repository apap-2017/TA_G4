package com.akademik.mahasiswa.g4.model.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WaktuModel {

    @JsonProperty("id")
    private int id;
    @JsonProperty("id_kelas")
    private int idKelas;
    @JsonProperty("ruangan")
    private String ruangan;
    @JsonProperty("hari")
    private String hari;
    @JsonProperty("jam_mulai")
    private String jamMulai;
    @JsonProperty("jam_akhir")
    private String jamAkhir;
    @JsonProperty("dosenPengajar")
    private List<DosenPengajarModel> dosenPengajars;

}
