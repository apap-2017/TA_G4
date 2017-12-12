package com.akademik.mahasiswa.g4.model.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

public class SpesifikNilaiResponseModel extends BaseResponseModel<SpesifikNilaiResponseModel.SpesifikNilaiResultModel> {

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    public static class SpesifikNilaiResultModel{
        @JsonProperty("daftar_nilai_kuliah")
        private List<NilaiKuliahModel> nilaiKuliahs;
    }

}
