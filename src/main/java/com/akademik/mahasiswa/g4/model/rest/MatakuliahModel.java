package com.akademik.mahasiswa.g4.model.rest;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MatakuliahModel {
    @JsonProperty("kode_mata_kuliah")
    private String kodeMK;
    @JsonProperty("kode_kurikulum")
    private String kurikulum;
    @JsonProperty("nama")
    private String nama;
    @JsonProperty("jumlah_sks")
    private int sks;
    @JsonProperty("jumlah_sks_minimal")
    private int sksMinimal;
    @JsonProperty("deskripsi")
    private String deskipsi;
    @JsonProperty("wajib")
    private boolean wajib;
    @JsonProperty("kelasList")
    private List<KelasModel> kelas;
    @JsonIgnore
    @Builder.Default
    private int selectedKelasIdx = -1;
}
