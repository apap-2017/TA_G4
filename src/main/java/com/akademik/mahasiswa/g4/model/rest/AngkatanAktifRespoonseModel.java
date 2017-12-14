package com.akademik.mahasiswa.g4.model.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

public class AngkatanAktifRespoonseModel extends BaseResponseModel<AngkatanAktifRespoonseModel.AngkatanAktifResultModel>{

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    public class AngkatanAktifResultModel{

        @JsonProperty("pengaturan_kurikulum_list")
        private List<AngkatanModel> angkatans;

    }

}
