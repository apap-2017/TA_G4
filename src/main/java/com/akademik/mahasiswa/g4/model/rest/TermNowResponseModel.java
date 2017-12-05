package com.akademik.mahasiswa.g4.model.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

public class TermNowResponseModel extends BaseResponseModel<TermNowResponseModel.TermNowResultModel> {

    public TermNowResponseModel(int status, String msg, TermNowResultModel result) {
        super(status, msg, result);
    }

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
