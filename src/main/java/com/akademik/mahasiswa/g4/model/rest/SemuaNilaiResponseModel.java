package com.akademik.mahasiswa.g4.model.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

public class SemuaNilaiResponseModel extends BaseResponseModel<SemuaNilaiResponseModel.NilaiResultModel> {

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    public static class NilaiResultModel{

        @JsonProperty("daftar_nilai_kuliah")
        private List<NilaiTermModel> nilaiModels;

        @AllArgsConstructor
        @NoArgsConstructor
        @Getter
        @Setter
        @ToString
        public static class NilaiTermModel{

            @JsonProperty("term")
            private TermModel term;
            @JsonProperty("list_nilai_kuliah")
            private List<NilaiKuliahModel> nilaiKuliahs;

        }
    }
}
