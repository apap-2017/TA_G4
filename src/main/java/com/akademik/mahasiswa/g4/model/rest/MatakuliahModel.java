package com.akademik.mahasiswa.g4.model.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MatakuliahModel {
    @JsonProperty("kode_mata_kuliah")
    private String kodeMK;
    @JsonProperty("nama")
    private String nama;
    @JsonProperty("jumlah_sks")
    private int sks;
//    private int sksMinimal;
//    private String deskipsi;
//    private boolean wajib;
    @JsonProperty("kelasList")
    private List<KelasModel> kelas;
}
