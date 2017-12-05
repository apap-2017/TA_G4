package com.akademik.mahasiswa.g4.model.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

public class PrasyaratMatkulResponseModel extends BaseResponseModel<PrasyaratMatkulResponseModel.PrasyaratMatkulResultModel> {

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    public static class PrasyaratMatkulResultModel{
        @JsonProperty("matkulList")
        private List<MatakuliahModel> matkulPrasyarats;
    }
}
