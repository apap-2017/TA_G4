package com.akademik.mahasiswa.g4.dao;

import com.akademik.mahasiswa.g4.model.rest.JadwalModel;
import com.akademik.mahasiswa.g4.model.rest.JadwalResponseModel;
import com.akademik.mahasiswa.g4.utls.NetworkUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

@Service
public class JadwalDAO {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    public JadwalModel getJadwalNow(int idUniv, int idFakultas, int idProdi, String angkatan){
        JadwalResponseModel response = restTemplateBuilder
                .build().getForObject(NetworkUtils.BASE_URL_SEKRETARIAT + "/api/getJadwalListNow/" + idUniv + "/" + idFakultas + "/" + idProdi + "/" + angkatan
                        ,JadwalResponseModel.class);

        if(response.getStatus() == 200){
            return response.getResult();
        }

        return null;
    }

}
