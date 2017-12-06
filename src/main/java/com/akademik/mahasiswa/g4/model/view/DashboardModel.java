package com.akademik.mahasiswa.g4.model.view;

import com.akademik.mahasiswa.g4.model.db.MahasiswaDBModel;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DashboardModel {

    private MahasiswaDBModel mahasiswa;
    private List<StatistikNilaiModel> statistikNilais;
    private String statusAkademik;
    private double ipk;

}
