package com.akademik.mahasiswa.g4.dao;

import com.akademik.mahasiswa.g4.model.db.MahasiswaDBModel;
import com.akademik.mahasiswa.g4.model.rest.TermModel;
import com.akademik.mahasiswa.g4.model.rest.TermNowResponseModel;
import com.akademik.mahasiswa.g4.utls.NetworkUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

@Service
public class TermDAO {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    public TermModel getTermNow(){
        //TODO get mahasiswa yang disimpen di sesion
        MahasiswaDBModel currentMahasiswa = new MahasiswaDBModel();
        //TODO remove this below dummy
        currentMahasiswa.setIdUniv(1);
        currentMahasiswa.setIdFakultas(1);
        currentMahasiswa.setIdProdi(1);

        TermNowResponseModel response = restTemplateBuilder
                .build().getForObject(NetworkUtils.BASE_URL_SEKRETARIAT + "/api/getTermNow/"
                                + currentMahasiswa.getIdUniv()
                                + "/" + currentMahasiswa.getIdFakultas()
                                + "/" + currentMahasiswa.getIdProdi()
                        ,TermNowResponseModel.class);

        if(response.getStatus() != 200
                || response.getResult() == null
                || response.getResult().getTermModel() == null){ // return null if some thing error
            return null;
        }

        return response.getResult().getTermModel();
    }

}
