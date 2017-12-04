package com.akademik.mahasiswa.g4.model.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class JadwalKelasModel {

    @JsonProperty("id")
    private int id;
    @JsonProperty("id_kelas")
    private int idKelas;
    @JsonProperty("ruangan")
    private String ruangan;
    @JsonProperty("hari")
    private String hari;
    @JsonProperty("jam_mulai")
    private String jamMulai;
    @JsonProperty("jam_akhir")
    private String jamAkhir;
    @JsonProperty("dosenPengajar")
    private List<DosenPengajarModel> dosenPengajars;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdKelas() {
        return idKelas;
    }

    public void setIdKelas(int idKelas) {
        this.idKelas = idKelas;
    }

    public String getRuangan() {
        return ruangan;
    }

    public void setRuangan(String ruangan) {
        this.ruangan = ruangan;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public String getJamMulai() {
        return jamMulai;
    }

    public void setJamMulai(String jamMulai) {
        this.jamMulai = jamMulai;
    }

    public String getJamAkhir() {
        return jamAkhir;
    }

    public void setJamAkhir(String jamAkhir) {
        this.jamAkhir = jamAkhir;
    }

    public List<DosenPengajarModel> getDosenPengajars() {
        return dosenPengajars;
    }

    public void setDosenPengajars(List<DosenPengajarModel> dosenPengajars) {
        this.dosenPengajars = dosenPengajars;
    }
}
