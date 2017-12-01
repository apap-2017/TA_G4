package com.akademik.mahasiswa.g4.model.rest;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class MatakuliahModel {
    private String kodeMK;
    private String nama;
    private int sks;
//    private int sksMinimal;
//    private String deskipsi;
//    private boolean wajib;
    private List<KelasModel> kelas;
}
