package com.akademik.mahasiswa.g4.dao;

import com.akademik.mahasiswa.g4.mapper.restMapper.UnivDAO;
import com.akademik.mahasiswa.g4.model.rest.FakultasModel;
import com.akademik.mahasiswa.g4.model.rest.ProdiModel;
import com.akademik.mahasiswa.g4.model.rest.UnivModel;
import com.akademik.mahasiswa.g4.utls.NetworkUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UnivDAOImpl implements UnivDAO{

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder)
    {
        return builder.build();
    }

    @Override
    public List<UnivModel> getAllUniv()
    {
        List<UnivModel> Univs = restTemplate.getForObject(
                NetworkUtils.BASE_URL_UNIVERSITAS + "/getUnivesitasList", List.class);

        return Univs;
    }

    @Override
    public List<FakultasModel> getAllFakultas()
    {
        List<FakultasModel> Fakults = restTemplate.getForObject(
                NetworkUtils.BASE_URL_UNIVERSITAS + "/getFakultasList", List.class);

        return Fakults;
    }

    @Override
    public List<ProdiModel> getAllProdi()
    {
        List<ProdiModel> Prodis= restTemplate.getForObject(
                NetworkUtils.BASE_URL_UNIVERSITAS + "/getProdiList", List.class);

        return Prodis;
    }

}
