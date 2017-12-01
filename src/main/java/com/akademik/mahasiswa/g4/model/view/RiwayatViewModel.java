package com.akademik.mahasiswa.g4.model.view;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * Class yang digunakan untuk menampilkan suatu riwayat matkul yang diambil mahasiswa
 * Class ini menampilkan riwayat pada tahun ajar dan term tertentu
 * Class ini dapat digunakan untuk :
 * - Menampilkan riwayat matakuliah mahasiswa
 * - Menampilkan IRS
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RiwayatViewModel {

    private String tahunAjaran;
    private int term;
    private List<MatakuliahViewModel> matakuliah;

}
