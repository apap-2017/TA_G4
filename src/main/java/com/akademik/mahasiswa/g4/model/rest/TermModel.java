package com.akademik.mahasiswa.g4.model.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Date;

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
    @JsonProperty("start_isi")
    private Date startIsi;
    @JsonProperty("akhir_isi")
    private Date akhirIsi;

}
