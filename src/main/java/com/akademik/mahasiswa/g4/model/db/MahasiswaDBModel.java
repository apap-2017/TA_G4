package com.akademik.mahasiswa.g4.model.db;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private int idUniv;
    private int idFakultas;
    private int idProdi;
    private String angkatan;

    @JsonIgnore
    private int sksDiperoleh;
    @JsonIgnore
    private int sksLulus;
}
