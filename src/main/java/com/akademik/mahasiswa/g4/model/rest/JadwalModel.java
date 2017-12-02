package com.akademik.mahasiswa.g4.model.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class JadwalModel {

    @JsonProperty("matkulList")
    private List<MatakuliahModel> matkul;
    @JsonProperty("term")
    private TermModel term;

}
