package com.akademik.mahasiswa.g4.model.view;

import com.akademik.mahasiswa.g4.model.db.MahasiswaDBModel;
import com.akademik.mahasiswa.g4.model.db.RiwayatPerkuliahanModel;
import com.akademik.mahasiswa.g4.model.rest.TermModel;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class IRSModel {

    private MahasiswaDBModel mahasiswa;
    private RiwayatPerkuliahanModel riwayat;
    private List<String> error;
    private int sksMaksimum;
    private double ipTerakhir;

    //drive atribut
    private int totalSKS;

    public MahasiswaDBModel getMahasiswa() {
        return mahasiswa;
    }

    public void setMahasiswa(MahasiswaDBModel mahasiswa) {
        this.mahasiswa = mahasiswa;
    }

    public RiwayatPerkuliahanModel getRiwayat() {
        return riwayat;
    }

    public void setRiwayat(RiwayatPerkuliahanModel riwayat) {
        this.riwayat = riwayat;
    }

    public List<String> getError() {
        return error;
    }

    public void setError(List<String> error) {
        this.error = error;
    }

    public int getSksMaksimum() {
        return sksMaksimum;
    }

    public void setSksMaksimum(int sksMaksimum) {
        this.sksMaksimum = sksMaksimum;
    }

    public double getIpTerakhir() {
        return ipTerakhir;
    }

    public void setIpTerakhir(double ipTerakhir) {
        this.ipTerakhir = ipTerakhir;
    }

    public int getTotalSKS() {
        return totalSKS;
    }

    public void setTotalSKS(int totalSKS) {
        this.totalSKS = totalSKS;
    }
}
