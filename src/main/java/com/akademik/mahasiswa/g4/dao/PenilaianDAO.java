package com.akademik.mahasiswa.g4.dao;

import com.akademik.mahasiswa.g4.model.rest.penilaian.NilaiResponseModel;
import com.akademik.mahasiswa.g4.utls.NetworkUtls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

@Service
public class PenilaianDAO {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    public NilaiResponseModel getSeluruhNilaiMahasiswa(String npm){
        NilaiResponseModel output = restTemplateBuilder
                .build().getForObject(NetworkUtls.BASE_URL + "/api/getRiwayatKuliah/" + npm
                        ,NilaiResponseModel.class);
        return output;
    }

}
