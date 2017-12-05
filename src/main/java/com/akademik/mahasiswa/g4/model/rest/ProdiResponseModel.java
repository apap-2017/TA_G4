package com.akademik.mahasiswa.g4.model.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

public class ProdiResponseModel extends BaseResponseModel<ProdiResponseModel.ProdiResultModel> {

    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    @Getter
    @Setter
    public static class ProdiResultModel{
        @JsonProperty("idUniv")
        private String idUniv;

        @JsonProperty("idFakultas")
        private String idFakultas;

        @JsonProperty("prodiList")
        private List<ProdiModel> prodiModel;
    }




}
