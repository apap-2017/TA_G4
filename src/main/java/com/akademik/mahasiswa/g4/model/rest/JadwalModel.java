package com.akademik.mahasiswa.g4.model.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class JadwalModel {

    @JsonProperty("matkulList")
    private List<MatakuliahModel> matkul;
    @JsonProperty("term")
    private TermModel term;

}