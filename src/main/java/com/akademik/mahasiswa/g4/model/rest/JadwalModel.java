package com.akademik.mahasiswa.g4.model.rest;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class JadwalModel {

    private List<MatakuliahModel> matkul;
    private TermModel term;

}
