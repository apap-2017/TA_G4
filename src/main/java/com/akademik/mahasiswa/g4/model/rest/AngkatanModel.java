package com.akademik.mahasiswa.g4.model.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AngkatanModel {

    @JsonProperty("angkatan")
    private String angkatan;

}
