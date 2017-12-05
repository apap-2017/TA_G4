package com.akademik.mahasiswa.g4.model.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.ArrayList;
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

    public List<MatakuliahModel> getMatkul() {
        return matkul;
    }

    public void setMatkul(List<MatakuliahModel> matkul) {
        this.matkul = matkul;
    }

    public TermModel getTerm() {
        return term;
    }

    public void setTerm(TermModel term) {
        this.term = term;
    }
}
