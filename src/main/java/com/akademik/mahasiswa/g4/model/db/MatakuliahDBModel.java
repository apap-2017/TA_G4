package com.akademik.mahasiswa.g4.model.db;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MatakuliahDBModel {

    private int idRiwayatPerkuliahan;
    private Date tanggalPengisian;
    private String mataKuliah;
    private String kodeKurikulum;
    private int idKelas;
}
