package com.akademik.mahasiswa.g4.model.view;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * Class yg merepresentasikan suatu matakuliah yang diambil oleh mahasiswa.
 * kelas ini dapat digunakan untuk :
 * - Menampilkan Riwayat Matakuliah
 * - Menampilkan IRS
 * - Menampilkan matakuliah yang tersedia untuk dipilih di pemilihan IRS
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MatakuliahViewModel {

    private String kodeMK;
    private String kurikulum;
    private String namaMK;
    private List<KelasViewModel> kelas;
    private int sks;
    private double nilaiAkhir;
    private String nilaiHuruf;

}
