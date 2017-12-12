package com.akademik.mahasiswa.g4.dao;

import com.akademik.mahasiswa.g4.model.rest.KurikulumMahasiswaResponseModel;
import com.akademik.mahasiswa.g4.model.rest.KurikulumModel;
import com.akademik.mahasiswa.g4.utls.NetworkUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

@Service
public class SekretariatDAO {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    public KurikulumModel getKurikulumMahasiswa(int idUniv, int idFakultas, int idProdi, int angkatan){
        KurikulumMahasiswaResponseModel response = restTemplateBuilder
                .build().getForObject(NetworkUtils.BASE_URL_SEKRETARIAT + "/api/getStudentKurikulum/"+idUniv+"/"+idFakultas+"/"+idProdi+"/" + angkatan
                        ,KurikulumMahasiswaResponseModel.class);
        if(response.getStatus() == 200)
            return response.getResult().getKurikulum();
        return null;
    }

}
