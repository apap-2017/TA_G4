package com.akademik.mahasiswa.g4.model.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class JadwalResponseModel extends BaseResponseModel<JadwalModel> {
    public JadwalResponseModel(int status, String msg, JadwalModel result) {
        super(status, msg, result);
    }
}
