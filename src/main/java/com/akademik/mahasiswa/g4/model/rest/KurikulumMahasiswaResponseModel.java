package com.akademik.mahasiswa.g4.model.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

public class KurikulumMahasiswaResponseModel extends BaseResponseModel<KurikulumMahasiswaResponseModel.KurikulumMahasiswaResultModel>{

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    public class KurikulumMahasiswaResultModel{
        @JsonProperty("pengaturan_kurikulum")
        private KurikulumModel kurikulum;

    }

}
