package com.akademik.mahasiswa.g4.model.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TermModel {

    @JsonProperty("tahun_ajaran")
    private String tahunAjar;
    @JsonProperty("nomor")
    private int nomor;

}
