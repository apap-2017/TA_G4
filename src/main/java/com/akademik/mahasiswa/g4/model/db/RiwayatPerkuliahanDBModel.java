package com.akademik.mahasiswa.g4.model.db;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RiwayatPerkuliahanDBModel {

    private int id;
    private boolean statusIrs;
    private String npm;
    private String tahunAjar;
    private int term;

}
