package com.akademik.mahasiswa.g4.model.rest.penilaian;

import com.akademik.mahasiswa.g4.model.rest.BaseResponseModel;
import com.akademik.mahasiswa.g4.model.rest.MatakuliahModel;
import com.akademik.mahasiswa.g4.model.rest.TermModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

public class NilaiResponseModel extends BaseResponseModel<NilaiResponseModel.NilaiResultModel> {

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    public static class NilaiResultModel{

        @JsonProperty("daftar_nilai_kuliah")
        private List<NilaiModel> nilaiModels;

        @AllArgsConstructor
        @NoArgsConstructor
        @Getter
        @Setter
        @ToString
        public static class NilaiModel{

            @JsonProperty("term")
            private TermModel term;
            @JsonProperty("list_nilai_kuliah")
            private List<NilaiKuliahModel> nilaiKuliahs;

            @AllArgsConstructor
            @NoArgsConstructor
            @Getter
            @Setter
            @ToString
            public static class NilaiKuliahModel{

                @JsonProperty("nilai")
                private int nilai;
                @JsonProperty("nilai_huruf")
                private String nilaiHuruf;
                @JsonProperty("kelas")
                private KelasModel kelas;

                @AllArgsConstructor
                @NoArgsConstructor
                @Getter
                @Setter
                @ToString
                public static class KelasModel{
                    @JsonProperty("mata_kuliah")
                    private MatakuliahModel matakuliah;

                }
            }
        }
    }
}
