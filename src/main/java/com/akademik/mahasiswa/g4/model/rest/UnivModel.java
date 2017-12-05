package com.akademik.mahasiswa.g4.model.rest;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UnivModel {
    private String idUniv;
    private String namaUniv;

    public String getIdUniv() {
        return idUniv;
    }

    public void setIdUniv(String idUniv) {
        this.idUniv = idUniv;
    }

    public String getNamaUniv() {
        return namaUniv;
    }

    public void setNamaUniv(String namaUniv) {
        this.namaUniv = namaUniv;
    }
}
