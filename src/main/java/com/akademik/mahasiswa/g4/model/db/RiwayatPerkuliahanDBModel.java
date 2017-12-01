package com.akademik.mahasiswa.g4.model.db;

public class RiwayatPerkuliahanDBModel {

    private int id;
    private boolean statusIrs;
    private String npm;
    private String tahunAjar;
    private int term;

    public RiwayatPerkuliahanDBModel(int id, boolean statusIrs, String npm, String tahunAjar, int term) {
        this.id = id;
        this.statusIrs = statusIrs;
        this.npm = npm;
        this.tahunAjar = tahunAjar;
        this.term = term;
    }

    public RiwayatPerkuliahanDBModel(){

    }

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
}
