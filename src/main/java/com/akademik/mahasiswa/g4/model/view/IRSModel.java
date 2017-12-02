package com.akademik.mahasiswa.g4.model.view;

import com.akademik.mahasiswa.g4.model.db.MahasiswaDBModel;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class IRSModel {

    private MahasiswaDBModel mahasiswa;
    private RiwayatViewModel riwayatPadaIRS;
    private List<String> error;
    private String sksMaksimum;
    private String ipTerakhir;

}
