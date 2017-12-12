package com.akademik.mahasiswa.g4.model.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

public class KurikulumResponseModel extends BaseResponseModel<KurikulumResponseModel.KurikulumResultModel> {

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    public class KurikulumResultModel{
        @JsonProperty("kurikulum")
        private KurikulumModel kurikulum;
    }
}
