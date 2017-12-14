package com.akademik.mahasiswa.g4.model.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UnivModel {

    @JsonProperty("id_univ")
    private int idUniv;

    @JsonProperty("nama_univ")
    private String namaUniv;


}
