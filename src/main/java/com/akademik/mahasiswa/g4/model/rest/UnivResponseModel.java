package com.akademik.mahasiswa.g4.model.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

public class UnivResponseModel extends BaseResponseModel<UnivResponseModel.UnivResultModel> {

    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    @Getter
    @Setter
    public static class UnivResultModel{
        @JsonProperty("univList")
        private List<UnivModel> listUniv;
    }




}
