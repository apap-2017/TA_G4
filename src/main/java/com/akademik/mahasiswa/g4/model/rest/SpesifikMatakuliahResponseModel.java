package com.akademik.mahasiswa.g4.model.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

public class SpesifikMatakuliahResponseModel extends BaseResponseModel<SpesifikMatakuliahResponseModel.SpesifikMatakuliahResultModel> {

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    public static class SpesifikMatakuliahResultModel{
        @JsonProperty("matkul")
        private MatakuliahModel matakuliahModel;
    }

}
