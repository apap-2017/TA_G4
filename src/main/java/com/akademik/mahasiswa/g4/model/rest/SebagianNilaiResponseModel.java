package com.akademik.mahasiswa.g4.model.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

public class SebagianNilaiResponseModel extends BaseResponseModel<SebagianNilaiResponseModel.NilaiResultModel> {

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    public static class NilaiResultModel{

        @JsonProperty("daftar_nilai_kuliah")
        private List<NilaiKuliahModel> nilaiKuliahs;

    }

}
