package com.akademik.mahasiswa.g4.model.view;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class KelasViewModel {

    private String nama;
    private int kapasitas;
    private int jumlahMhsSaatIni;
    private String jadwal;
    private String ruangan;
    private String pengajar;

}
