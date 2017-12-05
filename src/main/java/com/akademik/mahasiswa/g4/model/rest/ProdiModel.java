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
    private String idUniv;

    @JsonProperty("id_fakultas")
    private String idFakultas;

    @JsonProperty("id_prodi")
    private String idProdi;

    @JsonProperty("nama_prodi")
    private String namaProdi;

}
