package com.akademik.mahasiswa.g4.model.rest;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class KelasModel {
    @JsonProperty("id")
    private int id;
    @JsonProperty("nama")
    private String nama;
    @JsonProperty("max_kapasitas")
    private int kapasitas;
    @JsonIgnore
    private int mahasiswaSaatIni;
//    private int idUniv;
//    private int idFakultas;
//    private int idProdi;
    @JsonProperty("kode_mata_kuliah")
    private String kodeMK;
//    private int idTerm;
    @JsonProperty("jadwalList")
    private List<WaktuModel> waktu;


}
