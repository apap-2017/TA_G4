package com.akademik.mahasiswa.g4.model.rest;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MatakuliahModel {
    @JsonProperty("kode_mata_kuliah")
    private String kodeMK;
    @JsonProperty("kode_kurikulum")
    private String kurikulum;
    @JsonProperty("nama")
    private String nama;
    @JsonProperty("jumlah_sks")
    private int sks;
    @JsonProperty("jumlah_sks_minimal")
    private int sksMinimal;
    @JsonProperty("deskripsi")
    private String deskipsi;
    @JsonProperty("wajib")
    private boolean wajib;
    @JsonProperty("kelasList")
    private List<KelasModel> kelas;
    @JsonIgnore
    @Builder.Default
    private int selectedKelasIdx = -1;

    public String getKodeMK() {
        return kodeMK;
    }

    public void setKodeMK(String kodeMK) {
        this.kodeMK = kodeMK;
    }

    public String getKurikulum() {
        return kurikulum;
    }

    public void setKurikulum(String kurikulum) {
        this.kurikulum = kurikulum;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getSks() {
        return sks;
    }

    public void setSks(int sks) {
        this.sks = sks;
    }

    public int getSksMinimal() {
        return sksMinimal;
    }

    public void setSksMinimal(int sksMinimal) {
        this.sksMinimal = sksMinimal;
    }

    public String getDeskipsi() {
        return deskipsi;
    }

    public void setDeskipsi(String deskipsi) {
        this.deskipsi = deskipsi;
    }

    public boolean isWajib() {
        return wajib;
    }

    public void setWajib(boolean wajib) {
        this.wajib = wajib;
    }

    public List<KelasModel> getKelas() {
        return kelas;
    }

    public void setKelas(List<KelasModel> kelas) {
        this.kelas = kelas;
    }

    public int getSelectedKelasIdx() {
        return selectedKelasIdx;
    }

    public void setSelectedKelasIdx(int selectedKelasIdx) {
        this.selectedKelasIdx = selectedKelasIdx;
    }
}
