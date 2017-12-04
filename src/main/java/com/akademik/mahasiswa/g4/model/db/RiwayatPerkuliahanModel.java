package com.akademik.mahasiswa.g4.model.db;

import com.akademik.mahasiswa.g4.model.rest.KelasModel;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RiwayatPerkuliahanModel {

    private int id;
    private boolean statusIrs;
    private String npm;
    private String tahunAjar;
    private int term;
    private List<KelasModel> kelases;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isStatusIrs() {
        return statusIrs;
    }

    public void setStatusIrs(boolean statusIrs) {
        this.statusIrs = statusIrs;
    }

    public String getNpm() {
        return npm;
    }

    public void setNpm(String npm) {
        this.npm = npm;
    }

    public String getTahunAjar() {
        return tahunAjar;
    }

    public void setTahunAjar(String tahunAjar) {
        this.tahunAjar = tahunAjar;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public List<KelasModel> getKelases() {
        return kelases;
    }

    public void setKelases(List<KelasModel> kelases) {
        this.kelases = kelases;
    }
}
