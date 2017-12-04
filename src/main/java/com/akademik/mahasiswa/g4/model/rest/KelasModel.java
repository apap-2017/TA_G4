package com.akademik.mahasiswa.g4.model.rest;

import com.akademik.mahasiswa.g4.model.db.MahasiswaDBModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class KelasModel {
    @JsonProperty("id")
    private int idKelas;
    @JsonProperty("nama")
    private String namaKelas;
    @JsonProperty("max_kapasitas")
    private int kapasitas;
    @JsonProperty("jadwalList")
    private List<JadwalKelasModel> waktu;


    @JsonIgnore
    private int mahasiswaSaatIni;
    @JsonIgnore
    private int idRiwayatPerkuliahan;
    @JsonIgnore
    private Date tanggalPengisian;

    //akan disave di db
    private String namaMK;
    private String kodeMK;
    private String kurikulum;
    private int sks;

    //dapet dari api penilaian
    private double nilaiAkhir;
    private String nilaiHuruf;

    //for api to penilaian
    private List<MahasiswaDBModel> mahasiswa;

    public int getIdKelas() {
        return idKelas;
    }

    public void setIdKelas(int idKelas) {
        this.idKelas = idKelas;
    }

    public String getNamaKelas() {
        return namaKelas;
    }

    public void setNamaKelas(String namaKelas) {
        this.namaKelas = namaKelas;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public void setKapasitas(int kapasitas) {
        this.kapasitas = kapasitas;
    }

    public List<JadwalKelasModel> getWaktu() {
        return waktu;
    }

    public void setWaktu(List<JadwalKelasModel> waktu) {
        this.waktu = waktu;
    }

    public int getMahasiswaSaatIni() {
        return mahasiswaSaatIni;
    }

    public void setMahasiswaSaatIni(int mahasiswaSaatIni) {
        this.mahasiswaSaatIni = mahasiswaSaatIni;
    }

    public int getIdRiwayatPerkuliahan() {
        return idRiwayatPerkuliahan;
    }

    public void setIdRiwayatPerkuliahan(int idRiwayatPerkuliahan) {
        this.idRiwayatPerkuliahan = idRiwayatPerkuliahan;
    }

    public Date getTanggalPengisian() {
        return tanggalPengisian;
    }

    public void setTanggalPengisian(Date tanggalPengisian) {
        this.tanggalPengisian = tanggalPengisian;
    }

    public String getNamaMK() {
        return namaMK;
    }

    public void setNamaMK(String namaMK) {
        this.namaMK = namaMK;
    }

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

    public int getSks() {
        return sks;
    }

    public void setSks(int sks) {
        this.sks = sks;
    }

    public double getNilaiAkhir() {
        return nilaiAkhir;
    }

    public void setNilaiAkhir(double nilaiAkhir) {
        this.nilaiAkhir = nilaiAkhir;
    }

    public String getNilaiHuruf() {
        return nilaiHuruf;
    }

    public void setNilaiHuruf(String nilaiHuruf) {
        this.nilaiHuruf = nilaiHuruf;
    }

    public List<MahasiswaDBModel> getMahasiswa() {
        return mahasiswa;
    }

    public void setMahasiswa(List<MahasiswaDBModel> mahasiswa) {
        this.mahasiswa = mahasiswa;
    }
}
