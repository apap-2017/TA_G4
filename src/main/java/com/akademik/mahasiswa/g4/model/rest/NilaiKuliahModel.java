package com.akademik.mahasiswa.g4.model.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class NilaiKuliahModel{

    @JsonProperty("nilai")
    private int nilai;
    @JsonProperty("nilai_huruf")
    private String nilaiHuruf;
    @JsonProperty("kelas")
    private KelasModel kelas;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    public static class KelasModel{
        @JsonProperty("mata_kuliah")
        private MatakuliahModel matakuliah;

    }
}