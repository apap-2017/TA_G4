package com.akademik.mahasiswa.g4.model.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

public class SpesifikNilaiResponseModel extends BaseResponseModel<SpesifikNilaiResponseModel.SpesifikNilaiResultModel> {

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    public static class SpesifikNilaiResultModel{
        @JsonProperty("nilai_kuliah")
        private NilaiKuliahModel nilai;
    }

}
