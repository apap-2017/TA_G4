package com.akademik.mahasiswa.g4.dao;

import com.akademik.mahasiswa.g4.model.rest.KurikulumModel;
import com.akademik.mahasiswa.g4.model.rest.KurikulumResponseModel;
import com.akademik.mahasiswa.g4.model.rest.MatakuliahModel;
import com.akademik.mahasiswa.g4.model.rest.PrasyaratMatkulResponseModel;
import com.akademik.mahasiswa.g4.utls.NetworkUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KurikulumDAO {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    public KurikulumModel getKurikulum(String kodeKurikulum){
        KurikulumResponseModel response = restTemplateBuilder
                .build().getForObject(NetworkUtils.BASE_URL_KURIKULUM + "/api/getKurikulum/" + kodeKurikulum
                        ,KurikulumResponseModel.class);
        if(response.getStatus() == 200){
            return response.getResult();
        }
        return null;
    }

    public List<MatakuliahModel> getPrasyaratMatkul(String kodeMatkul, String kodeKurikulum){

        PrasyaratMatkulResponseModel response = restTemplateBuilder
                .build().getForObject(NetworkUtils.BASE_URL_KURIKULUM + "/api/getPrasyarat/" + kodeMatkul + "/" + kodeKurikulum
                        ,PrasyaratMatkulResponseModel.class);

        if(response.getStatus() == 200){
            return response.getResult().getMatkulPrasyarats();
        }

        return new ArrayList<>();
    }

}
