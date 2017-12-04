package com.akademik.mahasiswa.g4.model;

import com.akademik.mahasiswa.g4.model.rest.BaseResponseModel;
import com.akademik.mahasiswa.g4.model.rest.KelasModel;

public class PesertaKuliahModel extends BaseResponseModel<KelasModel> {
    public PesertaKuliahModel(int status, String msg, KelasModel result) {
        super(status, msg, result);
    }
}
