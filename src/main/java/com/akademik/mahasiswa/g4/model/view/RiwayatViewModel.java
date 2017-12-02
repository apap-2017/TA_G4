package com.akademik.mahasiswa.g4.model.view;

import com.akademik.mahasiswa.g4.model.rest.MatakuliahModel;
import lombok.*;

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
@Getter
@Setter
@ToString
public class RiwayatViewModel {

    private String tahunAjaran;
    private int term;
    private List<MatakuliahModel> matakuliah;

}
