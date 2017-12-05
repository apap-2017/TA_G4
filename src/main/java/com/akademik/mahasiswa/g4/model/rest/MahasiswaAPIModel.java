package com.akademik.mahasiswa.g4.model.rest;

import com.akademik.mahasiswa.g4.model.db.MahasiswaDBModel;
import com.akademik.mahasiswa.g4.model.rest.BaseResponseModel;
import com.akademik.mahasiswa.g4.model.rest.KelasModel;

public class MahasiswaAPIModel extends BaseResponseModel<MahasiswaDBModel> {
    public MahasiswaAPIModel(int status, String msg, MahasiswaDBModel result) {
        super(status, msg, result);
    }
}
