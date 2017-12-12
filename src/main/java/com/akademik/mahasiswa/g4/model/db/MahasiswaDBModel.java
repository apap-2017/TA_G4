package com.akademik.mahasiswa.g4.model.db;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonIgnore
    private String password;
    @JsonIgnore
    private String namaUniv;
    @JsonIgnore
    private String namaFakultas;
    @JsonIgnore
    private String namaProdi;
    @JsonProperty("id_univ")
    private int idUniv;
    @JsonProperty("id_fakultas")
    private int idFakultas;
    @JsonProperty("id_prodi")
    private int idProdi;
    private String angkatan;

    @JsonIgnore
    private int sksDiperoleh;
    @JsonIgnore
    private int sksLulus;
}
