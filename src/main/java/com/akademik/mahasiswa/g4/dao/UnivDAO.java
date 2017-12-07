package com.akademik.mahasiswa.g4.dao;

import com.akademik.mahasiswa.g4.model.rest.*;
import com.akademik.mahasiswa.g4.utls.NetworkUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UnivDAO {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;


    public UnivResponseModel getAllUniv()
    {
        UnivResponseModel Univs = restTemplateBuilder.build().getForObject(
                NetworkUtils.BASE_URL_UNIVERSITAS + "/getUniversitasList", UnivResponseModel.class);
        return Univs;
    }

    public UnivResponseModel getUniv(String idUniv)
    {
        // to do ambil univ dengan parameter
        UnivResponseModel univ = restTemplateBuilder.build().getForObject(
                NetworkUtils.BASE_URL_UNIVERSITAS + "/getUniversitas/" + idUniv, UnivResponseModel.class);

        return univ;
    }


    public FakultasResponseModel getAllFakultas(String idUniv)
    {
        FakultasResponseModel Fakults = restTemplateBuilder.build().getForObject(
                NetworkUtils.BASE_URL_UNIVERSITAS + "/getFakultasList/" + idUniv, FakultasResponseModel.class);

        return Fakults;
    }


    public ProdiResponseModel getAllProdi(String idUniv, String idFakultas)
    {
        ProdiResponseModel Prodis= restTemplateBuilder.build().getForObject(
                NetworkUtils.BASE_URL_UNIVERSITAS + "/getProdiList/" + idUniv + "/" + idFakultas, ProdiResponseModel.class);

        return Prodis;
    }

}
