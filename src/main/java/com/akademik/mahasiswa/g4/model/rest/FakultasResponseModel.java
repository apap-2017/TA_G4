package com.akademik.mahasiswa.g4.model.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

public class FakultasResponseModel extends BaseResponseModel<FakultasResponseModel.FakultasResultModel> {

    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    @Getter
    @Setter
    public static class FakultasResultModel{
        @JsonProperty("idUniv")
        private String idUniv;

        @JsonProperty("fakultasList")
        private List<FakultasModel> listFakultas;
    }

}
