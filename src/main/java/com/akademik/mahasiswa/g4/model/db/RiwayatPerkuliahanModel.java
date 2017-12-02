package com.akademik.mahasiswa.g4.model.db;

import com.akademik.mahasiswa.g4.model.rest.KelasModel;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RiwayatPerkuliahanModel {

    private int id;
    private boolean statusIrs;
    private String npm;
    private String tahunAjar;
    private int term;
    private List<KelasModel> kelases;

}
