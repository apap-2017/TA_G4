package com.akademik.mahasiswa.g4.model.db;

import java.util.Date;

public class MatakuliahDBModel {

    private int idRiwayatPerkuliahan;
    private Date tanggalPengisian;
    private String mataKuliah;
    private String kodeKurikulum;
    private int idKelas;

    public MatakuliahDBModel(int idRiwayatPerkuliahan, Date tanggalPengisian, String mataKuliah, String kodeKurikulum, int idKelas) {
        this.idRiwayatPerkuliahan = idRiwayatPerkuliahan;
        this.tanggalPengisian = tanggalPengisian;
        this.mataKuliah = mataKuliah;
        this.kodeKurikulum = kodeKurikulum;
        this.idKelas = idKelas;
    }

    public MatakuliahDBModel() {
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

    public String getMataKuliah() {
        return mataKuliah;
    }

    public void setMataKuliah(String mataKuliah) {
        this.mataKuliah = mataKuliah;
    }

    public String getKodeKurikulum() {
        return kodeKurikulum;
    }

    public void setKodeKurikulum(String kodeKurikulum) {
        this.kodeKurikulum = kodeKurikulum;
    }

    public int getIdKelas() {
        return idKelas;
    }

    public void setIdKelas(int idKelas) {
        this.idKelas = idKelas;
    }
}
