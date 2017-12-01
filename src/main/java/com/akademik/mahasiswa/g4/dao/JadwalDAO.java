package com.akademik.mahasiswa.g4.dao;

import com.akademik.mahasiswa.g4.model.rest.JadwalResponseModel;
import com.akademik.mahasiswa.g4.utls.NetworkUtls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

@Service
public class JadwalDAO {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    public JadwalResponseModel getJadwalNow(int idUniv, int idFakultas, int idProdi){
        JadwalResponseModel output = restTemplateBuilder
                .build().getForObject(NetworkUtls.BASE_URL + "/api/getJadwalList/" + idUniv + "/" + idFakultas + "/" + idProdi
                        ,JadwalResponseModel.class);
        return output;
    }

}
