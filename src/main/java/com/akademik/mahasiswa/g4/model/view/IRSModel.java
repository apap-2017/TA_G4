package com.akademik.mahasiswa.g4.model.view;

import com.akademik.mahasiswa.g4.model.db.MahasiswaDBModel;
import com.akademik.mahasiswa.g4.model.db.RiwayatPerkuliahanModel;
import com.akademik.mahasiswa.g4.model.rest.TermModel;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class IRSModel {

    private MahasiswaDBModel mahasiswa;
    private RiwayatPerkuliahanModel riwayat;
    private List<String> error;
    private int sksMaksimum;
    private double ipTerakhir;

    //drive atribut
    private int totalSKS;
}
