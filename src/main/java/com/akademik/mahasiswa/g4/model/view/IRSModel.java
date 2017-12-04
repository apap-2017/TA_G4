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
    private RiwayatPerkuliahanModel riwayatPadaIRS;
    private List<String> error;
    private String sksMaksimum;
    private String ipTerakhir;

    //drive atribut
    private int totalSks;

}
