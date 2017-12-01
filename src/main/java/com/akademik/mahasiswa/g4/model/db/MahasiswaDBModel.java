package com.akademik.mahasiswa.g4.model.db;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MahasiswaDBModel {
    private String npm;
    private String nama;
    private String username;
    private int idUniv;
    private int idProdi;
    private String angkata;
}
