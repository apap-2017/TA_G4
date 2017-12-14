package com.akademik.mahasiswa.g4.model.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProdiModel {

    @JsonProperty("id_univ")
    private int idUniv;

    @JsonProperty("id_fakultas")
    private int idFakultas;

    @JsonProperty("id_prodi")
    private int idProdi;

    @JsonProperty("nama_prodi")
    private String namaProdi;

}
