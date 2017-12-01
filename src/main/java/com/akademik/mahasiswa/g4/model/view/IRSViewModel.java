package com.akademik.mahasiswa.g4.model.view;

import com.akademik.mahasiswa.g4.model.db.MahasiswaDBModel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class IRSViewModel {

    private MahasiswaDBModel mahasiswa;
    private RiwayatViewModel riwayatPadaIRS;
    private List<String> error;
    private String sksMaksimum;
    private String ipTerakhir;

}
