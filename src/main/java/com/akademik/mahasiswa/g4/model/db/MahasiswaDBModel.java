package com.akademik.mahasiswa.g4.model.db;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MahasiswaDBModel {
    private String npm;
    private String nama;
    private String username;
    private int idUniv;
    private int idFakultas;
    private int idProdi;
    private String angkatan;
}
