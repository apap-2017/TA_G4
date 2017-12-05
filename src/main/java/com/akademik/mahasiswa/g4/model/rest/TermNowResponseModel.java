package com.akademik.mahasiswa.g4.model.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

public class TermNowResponseModel extends BaseResponseModel<TermNowResponseModel.TermNowResultModel> {

    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    @Getter
    @Setter
    public static class TermNowResultModel{
        @JsonProperty("term")
    private TermModel termModel;
}




}
