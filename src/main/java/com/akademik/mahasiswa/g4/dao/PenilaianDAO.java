package com.akademik.mahasiswa.g4.dao;

import com.akademik.mahasiswa.g4.model.rest.penilaian.NilaiResponseModel;
import com.akademik.mahasiswa.g4.utls.NetworkUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PenilaianDAO {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    public List<NilaiResponseModel.NilaiResultModel.NilaiModel> getSeluruhNilaiMahasiswa(String npm){
        NilaiResponseModel output = restTemplateBuilder
                .build().getForObject(NetworkUtils.BASE_URL_PENILAIAN + "/api/getNilaiKuliah/" + npm
                        ,NilaiResponseModel.class);
        if(output.getStatus() == 200 && output.getMsg().equals("success")){
            return output.getResult().getNilaiModels();
        }
        return new ArrayList<>();
    }

}
