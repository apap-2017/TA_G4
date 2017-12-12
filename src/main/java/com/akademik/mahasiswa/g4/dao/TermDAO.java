package com.akademik.mahasiswa.g4.dao;

import com.akademik.mahasiswa.g4.mapper.MahasiswaMapper;
import com.akademik.mahasiswa.g4.model.db.MahasiswaDBModel;
import com.akademik.mahasiswa.g4.model.rest.TermModel;
import com.akademik.mahasiswa.g4.model.rest.TermNowResponseModel;
import com.akademik.mahasiswa.g4.utls.NetworkUtils;
import com.akademik.mahasiswa.g4.utls.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

@Service
public class TermDAO {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @Autowired
    private MahasiswaMapper mahasiswaMapper;

    public TermModel getTermNow(){
        //get mahasiswa yang login
        MahasiswaDBModel currentMahasiswa = mahasiswaMapper.getMahasiswaByUsername(UserUtils.getUsername());

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
