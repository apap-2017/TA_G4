package com.akademik.mahasiswa.g4.model.rest.penilaian;

import com.akademik.mahasiswa.g4.model.rest.BaseResponseModel;
import com.akademik.mahasiswa.g4.model.rest.MatakuliahModel;
import com.akademik.mahasiswa.g4.model.rest.TermModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

public class NilaiResponseModel extends BaseResponseModel<NilaiResponseModel.NilaiResultModel> {

    public NilaiResponseModel(int status, String msg, NilaiResultModel result) {
        super(status, msg, result);
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    public static class NilaiResultModel{

        @JsonProperty("daftar_nilai_kuliah")
        private List<NilaiModel> nilaiModels;

        public List<NilaiModel> getNilaiModels() {
            return nilaiModels;
        }

        public void setNilaiModels(List<NilaiModel> nilaiModels) {
            this.nilaiModels = nilaiModels;
        }

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

            public TermModel getTerm() {
                return term;
            }

            public void setTerm(TermModel term) {
                this.term = term;
            }

            public List<NilaiKuliahModel> getNilaiKuliahs() {
                return nilaiKuliahs;
            }

            public void setNilaiKuliahs(List<NilaiKuliahModel> nilaiKuliahs) {
                this.nilaiKuliahs = nilaiKuliahs;
            }

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

                public int getNilai() {
                    return nilai;
                }

                public void setNilai(int nilai) {
                    this.nilai = nilai;
                }

                public String getNilaiHuruf() {
                    return nilaiHuruf;
                }

                public void setNilaiHuruf(String nilaiHuruf) {
                    this.nilaiHuruf = nilaiHuruf;
                }

                public KelasModel getKelas() {
                    return kelas;
                }

                public void setKelas(KelasModel kelas) {
                    this.kelas = kelas;
                }

                @AllArgsConstructor
                @NoArgsConstructor
                @Getter
                @Setter
                @ToString
                public static class KelasModel{
                    @JsonProperty("mata_kuliah")
                    private MatakuliahModel matakuliah;

                    public MatakuliahModel getMatakuliah() {
                        return matakuliah;
                    }

                    public void setMatakuliah(MatakuliahModel matakuliah) {
                        this.matakuliah = matakuliah;
                    }
                }
            }
        }
    }
}
