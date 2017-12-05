package com.akademik.mahasiswa.g4.model.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class FakultasModel {

    @JsonProperty("univ")
    private String idUniv;

    @JsonProperty("id_fakultas")
    private String idFakultas;

    @JsonProperty("nama_fakultas")
    private String namaFakultas;

}
