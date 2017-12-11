package com.akademik.mahasiswa.g4.model.view;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class StatistikNilaiModel {

    private String tahunAjaran;
    private int term;
    private int totalMK;
    private int totalSKS;
    private int totalSKSLulus;
    private double ip;

}
